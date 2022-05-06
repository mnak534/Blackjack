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

	public String getResult(int round) {
		if (resultsList.get(round) == 0) {
			return " lost ";
		} else {
			return " won ";
		}
	}

	// Add a result to resultsArray
	public void addResult(int result) {
		resultsList.add(result);
	}

	public int howManyWon() {
		int winCount = 0;
		for (Integer i : resultsList) {
			if (i == 1) {
				winCount++;
			}
		}
		return winCount;
	}

	public int howManyLost() {
		// the game played should be the size of the resultsList
		return resultsList.size() - howManyWon();
	}
}
