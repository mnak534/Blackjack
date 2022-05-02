package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public class LowRiskStrategy implements Strategy {

	@Override
	public Action action(Hand hand) {
		// if the score is higher or equal to 17, it holds
		if (hand.getScore() >= 17) {
			return Action.HOLD;
		}
		// else, it hits
		else {
			return Action.HIT;
		}
	}

	@Override
	public int bet() {
		// Create a Random instance
		Random rand = new Random();

		// Obtain a random integer between 0-40 (inclusive)
		int n = rand.nextInt(41);

		// It rondomly bets between 10-50 (inclusive)
		return n + 10;
	}

}
