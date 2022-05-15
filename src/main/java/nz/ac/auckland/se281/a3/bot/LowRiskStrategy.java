package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public class LowRiskStrategy implements BotStrategy {

	/**
	 * Method that implements the low risk stragy in which a Bot HOLD if the current
	 * hand has a score >=17, HIT otherwise.
	 * 
	 * @param hand : an Hand instance
	 * @return Action that a Bot plays for the round
	 */
	@Override
	public Action action(Hand hand) {
		// if the score is higher or equal to 17, it holds
		if (hand.getScore() >= 17) {
			return Action.HOLD;
		}
		// otherwise, it hits
		else {
			return Action.HIT;
		}
	}

	/**
	 * Method that implements the low risk stragy in which a Bot bets randomly from
	 * 10 to 50 (inclusive).
	 * 
	 * @return the amount of bet of the Bot for the round
	 */
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
