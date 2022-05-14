package nz.ac.auckland.se281.a3;

import java.util.ArrayList;
import java.util.List;

import nz.ac.auckland.se281.a3.bot.Bot;
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
	 */
	protected void initBots() {
		Bot bot1 = new Bot("Bot1");
		Bot bot2 = new Bot("Bot2");

		String botStrategyString = getBotStrategy(); // UNCOMMENT THIS

		// create and set Bots strategy here
		bot1.setBotStrategy(botStrategyString);
		bot2.setBotStrategy(botStrategyString);

		players.add(bot1);
		players.add(bot2);
	}

	/**
	 * TODO This method initializes the Dealer, you should change this method for
	 * Task2
	 */
	protected void initDealer() {
		// set the initial strategy using the Strategy pattern
		dealer = new Dealer("Dealer");
		dealer.setDealerStrategy(new TargetHighestBidder(this.players));
	}

	/**
	 * TODO This method prints and updates the results (wins and losses) you should
	 * change this method for Task 2 and Task 3
	 * 
	 * @param round : a round number of the current round
	 */
	protected void printAndUpdateResults(int round) {

		// Determines each player's result for a round and update the results
		getResult();
		// Determines if the strategy of the dealer should be changed or not
		strategyChange();

		// Loop to print the result for each player
		for (Player player : players) {
			// Print the result
			System.out.println("Round " + round + ": " + player.getName() + " " + player.getCurrentResult() + " "
					+ player.getHand().getBet() + " chips");
		}
	}

	/**
	 * Update the netwins and decide if the dealer strategy should be changed or not
	 */
	private void strategyChange() {

		boolean netWinsMoreThanTwo = false;

		// Loop through each player to see if there is at least one pleayer with netwins
		// >=2
		for (Player player : players) {
			// If there is, change the dealer strategy to the one that targets the top
			// winner
			if (player.getNetWins() >= 2) {
				netWinsMoreThanTwo = true;
			}
		}

		if (netWinsMoreThanTwo) {
			dealer.setDealerStrategy(new TargetTopWinner(this.players));
//			System.out.println("The delaer strategy is changed to the TargetTopWinner");
		} else {
			dealer.setDealerStrategy(new TargetHighestBidder(this.players));
//			System.out.println("The delaer strategy is changed to the TargetHighestBidder");
		}
	}

	/**
	 * Determines whether each player wins or loses in the round, and store the
	 * results
	 */
	protected void getResult() {

		// Stores the hand of the dealer
		Hand dealerHand = dealer.getHand();

		// Determines whether each player won or lost
		for (Player player : players) {

			// Stores the hand of a player
			Hand playerHand = player.getHand();

			// Declare the result of a player in the round
			boolean playerWon = true;

			// All the possible cases that a player loses

			// 1. If a player is busted, the player loses
			if (playerHand.isBust()) {
				playerWon = false;
			}

			// 2. If a player and the dealer both have blackjack, the player loses
			else if (playerHand.isBlackJack() && dealerHand.isBlackJack()) {
				playerWon = false;
			}

			// 3. If a player's score is <=21 and not blackjack
			else if (playerHand.getScore() <= 21 && !playerHand.isBlackJack()) {
				// 3(i). if the dealer is blackjack, then the player loses
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
				player.incrementHowManyWon();
			} else {
				player.incrementHowManyLost();
			}
			player.updateResult(playerWon);
		}
	}

	/**
	 * TODO This method should print the statistic of the game when it ends
	 */
	protected void printGameStatistics() {
		for (Player player : players) {
			// Print the static
			System.out.println(player.getName() + " won " + player.getHowManyWon() + " times and lost "
					+ player.getHowManyLost() + " times");
		}
	}

}
