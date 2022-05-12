package nz.ac.auckland.se281.a3;

import java.util.ArrayList;

/**
 * 
 * You can (and should) add new fields and/or methods
 *
 */
public abstract class Player extends Participant {

	private ArrayList<Integer> resultsList = new ArrayList<>(); // 0 means a player lost, abd 1 means a player won
	private int netwins;

	public Player(String name) {
		super(name);
	}

	public abstract int makeABet();

	/**
	 * Getter method to get this player's game result in a specified round.
	 * 
	 * @param round : a round number
	 * @return whether this player won or lost in a specified round
	 */
	public String getResult(int round) {
		if (resultsList.get(round) == 0) {
			return " lost ";
		} else {
			return " won ";
		}
	}

	/**
	 * Setter method to add a game result to this player's game record.
	 * 
	 * @param result : a number indicating the result of the game. O indicates lost
	 *               and 1 indicates won.
	 */
	public void addResult(int result) {
		resultsList.add(result);
	}

	public int getNetWins() {
		netwins = 0;
		for (int i = 0; i < resultsList.size(); i++) {
			netwins += resultsList.get(i);
		}
		return netwins;
	}

}
