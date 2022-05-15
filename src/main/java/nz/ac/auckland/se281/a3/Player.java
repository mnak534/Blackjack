package nz.ac.auckland.se281.a3;

/**
 * 
 * You can (and should) add new fields and/or methods
 *
 */
public abstract class Player extends Participant {

	private int netwins; // net wins = #rounds won - #rounds lost
	private int howManyWon = 0; // #rounds won
	private int howManyLost = 0; // #rounds lost
	private String currentResult; // store the result (won/lost) for the most recent round

	public Player(String name) {
		super(name);
	}

	public abstract int makeABet();

	/**
	 * 
	 * Update currentResult field that indicates the player's result for the most
	 * recent round.
	 * 
	 * @param currentResult a boolean variable indicating if this player won in the
	 *                      most recent round.
	 */
	public void updateResult(boolean currentResult) {
		if (currentResult) {
			this.currentResult = "won";
		} else {
			this.currentResult = "lost";
		}
	}

	/**
	 * Getter method for currentResult
	 * 
	 * @return this Player's result in the most recent round.
	 */
	public String getCurrentResult() {
		return this.currentResult;
	}

	/**
	 * Method to increment howManyWon field when the player won a round
	 */
	public void incrementHowManyWon() {
		this.howManyWon++;
	}

	/**
	 * Method to increment howManyLost field when the player lost a round
	 */
	public void incrementHowManyLost() {
		this.howManyLost++;
	}

	/**
	 * Calculate the netwins by #rounds won - #rounds lost, and update the value of
	 * netwins field.
	 * 
	 * @return the netwins of this player
	 */
	public int getNetWins() {
		this.netwins = this.howManyWon - this.howManyLost;
		return this.netwins;
	}

	/**
	 * Getter method for howManyWon field
	 * 
	 * @return the total number of rounds this user has won
	 */
	public int getHowManyWon() {
		return this.howManyWon;
	}

	/**
	 * Getter method for howManyLost field
	 * 
	 * @return the total number of rounds this user has lost
	 */
	public int getHowManyLost() {
		return this.howManyLost;
	}
}
