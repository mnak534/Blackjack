package nz.ac.auckland.se281.a3;

import java.util.ArrayList;

/**
 * 
 * You can (and should) add new fields and/or methods
 *
 */
public abstract class Player extends Participant {

	private ArrayList<Integer> resultsList = new ArrayList<>(); // 0 is lost, 1 is win

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

	/**
	 * Count how many times this player won so far.
	 * 
	 * @return number of times this player has won
	 */
	public int howManyWon() {
		int winCount = 0;
		for (Integer i : resultsList) {
			if (i == 1) {
				winCount++;
			}
		}
		return winCount;
	}

	/**
	 * Count how many times this player lost so far.
	 * 
	 * @return number of times this player has lost.
	 */
	public int howManyLost() {
		// the number of games played should be the size of the resultsList
		return resultsList.size() - howManyWon();
	}
}
