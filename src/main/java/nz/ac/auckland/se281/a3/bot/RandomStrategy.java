package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Participant.Action;

public class RandomStrategy implements Strategy {

	@Override
	public Action action() {

		// Create a Random instance
		Random rand = new Random();

		// Obtain a random integer between 0-1 (inclusive)
		int n = rand.nextInt(2);

		// n is 0 or 1 for 50-50 chance
		// -> Random strategy randomly chooses the action HOLD and HIT.
		if (n == 0) {
			return Action.HIT;
		} else {
			return Action.HOLD;
		}
	}

	@Override
	public int bet() {
		// Create a Random instance
		Random rand = new Random();

		// Obtain a random integer between 0-99 (inclusive)
		int n = rand.nextInt(100);

		// Random strategy bets randomly between 1 and 100 chips (inclusive).
		System.out.println("Bet amount " + (n + 1));
		return n + 1;
	}

}
