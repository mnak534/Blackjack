package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public class HighRiskStrategy implements BotStrategy {

	/**
	 * Method that implements the high risk stragy in which a Bot HOLD if the
	 * current hand has a score >=19, HIT otherwise.
	 * 
	 * @param hand : an Hand instance
	 * @return Action that a Bot plays for the round
	 */
	@Override
	public Action action(Hand hand) {
		// if the score is >= 19, it HOLDs
		if (hand.getScore() >= 19) {
			return Action.HOLD;
		}
		// otherwise, it HITs
		else {
			return Action.HIT;
		}
	}

	/**
	 * Method that implements the high risk stragy in which a Bot bets randomly from
	 * 50 to 100 (inclusive).
	 * 
	 * @return the amount of bet of the Bot for the round
	 */
	@Override
	public int bet() {
		// Create a Random instance
		Random rand = new Random();
		// Obtain a random integer between 0-50 (inclusive)
		int n = rand.nextInt(51);
		// It randomly bets between 50-100 (inclusive)
		return n + 50;
	}

}
