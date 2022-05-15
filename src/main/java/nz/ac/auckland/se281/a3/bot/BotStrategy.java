package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public interface BotStrategy {

	/**
	 * Decides an Action of a Bot (HIT or HOLD) for the round
	 * 
	 * @param hand : a Hand instance of the Bot that this BotStrategy belongs to
	 * @return an Action for a game (HIT or HOLD)
	 */
	Action action(Hand hand);

	/**
	 * Decides a bet amount a bot bets for the round
	 * 
	 * @return the amount of a bet for a round
	 */
	int bet();
}
