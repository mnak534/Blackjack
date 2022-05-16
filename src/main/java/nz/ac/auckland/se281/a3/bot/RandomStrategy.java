package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public class RandomStrategy implements BotStrategy {

	/**
	 * Method that implements the random stragy in which a Bot chooses HIT or HOLD
	 * randomly.
	 * 
	 * @param hand : an Hand instance
	 * @return Action that a Bot plays for the round
	 */
	@Override
	public Action action(Hand hand) {

		// Create a Random instance
		Random rand = new Random();
		// Obtain a random integer that is 0 or 1
		int n = rand.nextInt(2);

		// n is 0 or 1 for 50-50 chance
		// -> Random strategy randomly chooses the action HOLD and HIT.
		if (n == 0) {
			return Action.HIT;
		} else {
			return Action.HOLD;
		}

	}

	/**
	 * Method that implements the random stragy in which a Bot bets randomly from 1
	 * to 100 (inclusive).
	 * 
	 * @return the amount of bet of the Bot for the round
	 */
	@Override
	public int bet() {
		// Create a Random instance
		Random rand = new Random();
		// Obtain a random integer between 0-99 (inclusive)
		int n = rand.nextInt(100);

		// Random strategy bets randomly between 1 and 100 chips (inclusive).
		return n + 1;
	}

}
