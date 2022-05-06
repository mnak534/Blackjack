package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public class HighRiskStrategy implements BotStrategy {

	@Override
	public Action action(Hand hand) {
		// if the score is higher or equal to 17, it holds
		if (hand.getScore() >= 19) {
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

		// Obtain a random integer between 0-50 (inclusive)
		int n = rand.nextInt(51);

		// It rondomly bets between 50-100 (inclusive)
		return n + 50;
	}

}
