package nz.ac.auckland.se281.a3;

import java.util.ArrayList;

/**
 * 
 * You can (and should) add new fields and/or methods
 *
 */
public abstract class Player extends Participant {

	private ArrayList<Integer> resultsArray = new ArrayList<>(); // 0 is lost, 1 is win

	public Player(String name) {
		super(name);
	}

	public abstract int makeABet();

	public String getResult(int round) {
		if (resultsArray.get(round) == 0) {
			return " lost ";
		} else {
			return " won ";
		}
	}

	// Add a result to resultsArray
	public void addResult(int result) {
		resultsArray.add(result);
	}
}
