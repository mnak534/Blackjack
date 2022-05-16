package nz.ac.auckland.se281.a3;

import java.util.ArrayList;
import java.util.List;

import nz.ac.auckland.se281.a3.bot.Bot;
import nz.ac.auckland.se281.a3.bot.BotStrategy;
import nz.ac.auckland.se281.a3.bot.BotStrategyFactory;
import nz.ac.auckland.se281.a3.dealer.Dealer;
import nz.ac.auckland.se281.a3.dealer.TargetHighestBidder;
import nz.ac.auckland.se281.a3.dealer.TargetTopWinner;

/**
 * Unless it is specified in the JavaDoc, you cannot change any methods.
 * 
 * You can add new methods and/or new instance fields
 */
public class BlackJack {

	private List<Player> players; // Only contains players, not a dealer
	private Dealer dealer;
	private Deck deck;

	public BlackJack(Deck deck) {
		this.deck = deck;
		players = new ArrayList<>();
		players.add(new Human("Player1")); // add the Human player first.
	}

	/**
	 * This constructor is for testing reasons
	 * 
	 * @param cards
	 */
	protected BlackJack(Card... cards) {
		this(new Deck(cards));

	}

	public BlackJack() {
		this(new Deck());
	}

	public List<Player> getPlayers() {
		return players;
	}

	private String getBotStrategy() {
		System.out.println("Choose Bot strategy: random (R) - low risk (LR) - high risk (HR)");
		String result = Main.scanner.next();
		while (!result.equals("R") && !result.equals("LR") && !result.equals("HR") && !result.equals("A")) {
			System.out.println("please type \"R\", \"LR\",  \"HR\"");
			result = Main.scanner.next();
		}
		return result;
	}

	// do not change this method
	public void start() {
		initBots();
		initDealer();
		String res;
		int round = 0;
		do {
			round++;
			for (Participant p : players) {
				p.play(deck, round);
			}
			dealer.play(deck, round);
			printAndUpdateResults(round); // after each game print result and update scoreboard
			System.out.println("Do you want to play again?");
			res = Main.scanner.next();
			while (!res.equals("yes") && !res.equals("no")) {
				System.out.println("please type either \"yes\" or \"no\"");
				res = Main.scanner.next();
			}
		} while (res.equals("yes"));
		printGameStatistics(); // when the user terminates the game print the statistics
	}

	/**
	 * TODO This method initializes the Bots, you should change this method for
	 * Task1
	 * 
	 * Create two Bot instances and instantiate BotStrategy depending on the user's
	 * choice, and set the strategy as these two Bots' strategies. Add the bots to
	 * the playerers list.
	 */
	protected void initBots() {
		// Create two Bot instances
		Bot bot1 = new Bot("Bot1");
		Bot bot2 = new Bot("Bot2");

		// Get which strategy a user wants bots to play
		String botStrategyString = getBotStrategy(); // UNCOMMENT THIS

		// Create an instance of BotStrategy class of the user's choice
		BotStrategy botStrategy = BotStrategyFactory.createBotStrategy(botStrategyString);

		// Set the strategy instance as both of the bots' strategy
		bot1.setBotStrategy(botStrategy);
		bot2.setBotStrategy(botStrategy);

		// Add bo1 and bot2 in the players list
		players.add(bot1);
		players.add(bot2);
	}

	/**
	 * TODO This method initializes the Dealer, you should change this method for
	 * Task2
	 * 
	 * Initialise the Dealer by creating a new Dealer instance and set the strategy
	 * that targets the highest bidder as the initial strategy.
	 */
	protected void initDealer() {
		// set the initial strategy using the Strategy pattern

		// Instantiate Dealer
		dealer = new Dealer("Dealer");

		// Initially, Dealer uses the Targeting the Highest Bidder strategy
		dealer.setDealerStrategy(new TargetHighestBidder(this.players));
	}

	/**
	 * TODO This method prints and updates the results (wins and losses) you should
	 * change this method for Task 2 and Task 3
	 * 
	 * This method is called after every round.
	 * 
	 * Determines the results of each player, and update the results, and checks if
	 * the Dealer needs to change the strategy. Then, print the result for each
	 * player.
	 * 
	 * @param round : a round number of the current round
	 * 
	 */
	protected void printAndUpdateResults(int round) {

		// Determines each player's result for the round and update the results
		getResult();

		// After updated the result, determine if the dealer's strategy should be
		// changed or not
		changeStrategy();

		// Loop to print the result for each player
		for (Player player : players) {
			// Print the result
			System.out.println("Round " + round + ": " + player.getName() + " " + player.getCurrentResult() + " "
					+ player.getHand().getBet() + " chips");
		}
	}

	/**
	 * This methods sets the Dealer's strategy after determining the Dealer should
	 * change the strategy or not by counting the net-wins of each player.
	 * 
	 */
	private void changeStrategy() {

		// netWinsMoreThanTwo indicates if there is at least one player with netwins>=2
		boolean netWinsMoreThanTwo = false;

		// Loop through each player to see if there is at least one pleayer with
		// netwins >=2
		for (Player player : players) {
			if (player.getNetWins() >= 2) {
				netWinsMoreThanTwo = true;
			}
		}

		// If there is, the dealer should play the strategy that targets the top winner
		if (netWinsMoreThanTwo) {
			dealer.setDealerStrategy(new TargetTopWinner(this.players));
		}
		// Otherwise, the dealer plays the strategy that targets the highest bidder
		else {
			dealer.setDealerStrategy(new TargetHighestBidder(this.players));
		}
	}

	/**
	 * Determines whether each player won or lost in the round, and store the
	 * results
	 */
	protected void getResult() {

		// the Hand of the Dealer
		Hand dealerHand = dealer.getHand();

		// loop to determine whether each player won or lost
		for (Player player : players) {

			// the Hand of a Player
			Hand playerHand = player.getHand();

			// a variable indicates if the player won in the round,
			// initialise it to true (= the player won)
			boolean playerWon = true;

			// List all the possible cases that a player loses

			// 1. If a player is busted, the player loses regardless
			if (playerHand.isBust()) {
				playerWon = false;
			}

			// 2. If a player and the dealer both have blackjack, the player loses
			if (playerHand.isBlackJack() && dealerHand.isBlackJack()) {
				playerWon = false;
			}

			// 3. If a player's score is <=21 and not blackjack
			if (playerHand.getScore() <= 21 && !playerHand.isBlackJack()) {
				// 3(i). if the dealer has blackjack, then the player loses
				if (dealerHand.isBlackJack()) {
					playerWon = false;
				}
				// 3(ii). if the dealer's score is <=21 and not blackjack
				// AND if a player's score is <= dealer's score, the player loses
				if (dealerHand.getScore() <= 21 && !dealerHand.isBlackJack()
						&& playerHand.getScore() <= dealerHand.getScore()) {
					playerWon = false;
				}
			}

			// Store the result
			if (playerWon) {
				// If a player won, increment the number of rounds the player won so far.
				player.incrementHowManyWon();
			} else {
				// If a player lost, increment the number of rounds the player lost so far.
				player.incrementHowManyLost();
			}
			// Store the most recent round result.
			player.updateResult(playerWon);
		}
	}

	/**
	 * TODO This method should print the statistic of the game when it ends
	 */
	protected void printGameStatistics() {
		// Loop through each player in a list.
		for (Player player : players) {
			// Print the static
			System.out.println(player.getName() + " won " + player.getHowManyWon() + " times and lost "
					+ player.getHowManyLost() + " times");
		}
	}

}
