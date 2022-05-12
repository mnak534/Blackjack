package nz.ac.auckland.se281.a3;

import java.util.ArrayList;
import java.util.List;

import nz.ac.auckland.se281.a3.bot.Bot;
import nz.ac.auckland.se281.a3.dealer.Dealer;
import nz.ac.auckland.se281.a3.dealer.HighestBidderStrategy;
import nz.ac.auckland.se281.a3.dealer.TopWinnerStrategy;

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
		bot1.strategyFactory(botStrategyString);
		bot2.strategyFactory(botStrategyString);

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
		dealer.setDealerStrategy(new HighestBidderStrategy(this));
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
			System.out.println("Round " + round + ": " + player.getName() + " " + player.getResult(round)
					+ player.getHand().getBet() + " chips");
		}
	}

	/**
	 * Update the netwins and decide if the dealer strategy should be changed or not
	 */
	private void strategyChange() {
		// Loop through each player to see if there is at least one pleayer with netwins
		// >=2
		for (Player player : players) {
			// If there is, change the dealer strategy to the one that targets the top
			// winner
			if (player.getNetWins() >= 2) {
				dealer.setDealerStrategy(new TopWinnerStrategy(this));
			}
			// Otherwise, change the dealer strategy to the one that targets the highest
			// bidder
			else {
				dealer.setDealerStrategy(new HighestBidderStrategy(this));
			}
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
			// 0 = player lost, 1 = player won
			int result = 1;

			// All the possible cases that a player loses
			if (playerHand.isBust()) {
				result = 0;
			} else if (playerHand.isBlackJack() && dealerHand.isBlackJack()) {
				result = 0;
			} else if (playerHand.getScore() <= dealerHand.getScore() && !dealerHand.isBust()) {
				result = 0;
			}

			// Store the result
			player.addResult(result);
		}
	}

	/**
	 * TODO This method should print the statistic of the game when it ends
	 */
	protected void printGameStatistics() {
		for (Player player : players) {
			// Print the static
//			System.out.println(player.getName() + " won " + player.howManyWon() + " times and lost "
//					+ player.howManyLost() + " times");
		}
	}

}
