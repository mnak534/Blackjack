package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public interface BotStrategy {

	/**
	 * Decides whether hit or hold
	 * 
	 * @param hand : a Hand instance
	 * @return an action for a game (HIT or HOLD)
	 */
	Action action(Hand hand);

	/**
	 * Decides a bet amount
	 * 
	 * @return the amount of a bet for a gameS
	 */
	int bet();
}
