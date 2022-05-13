package nz.ac.auckland.se281.a3;

/**
 * 
 * You can (and should) add new fields and/or methods
 *
 */
public abstract class Player extends Participant {

	private int netwins;
	private int howManyWon;
	private int howManyLost;
	private String currentResult;

	public Player(String name) {
		super(name);
	}

	public abstract int makeABet();

	// TO DO
	public void updateResult(boolean currentResult) {
		if (currentResult) {
			this.currentResult = "won";
		} else {
			this.currentResult = "lost";
		}
	}

	public String getCurrentResult() {
		return this.currentResult;
	}

	// TO DO
	public void incrementNetWins() {
		this.netwins++;
	}

	// TO DO
	public void decrementNetWins() {
		this.netwins--;
	}

	// TO DO
	public int getNetWins() {
		return netwins;
	}

	// TO DO
	public int getHowManyWon() {
		return this.howManyWon;
	}

	// TO DO
	public int getHowManyLost() {
		return this.howManyLost;
	}
}
