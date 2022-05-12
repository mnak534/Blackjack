package nz.ac.auckland.se281.a3.dealer;

import nz.ac.auckland.se281.a3.BlackJack;
import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;
import nz.ac.auckland.se281.a3.Player;

public abstract class DealerStrategy {

	// Instance fields
	protected Player target;
	protected BlackJack game;

	/**
	 * Constructor for DealerStrategy
	 * 
	 */
	public DealerStrategy(BlackJack game) {
		this.game = game;
	}

	/**
	 * Decides whether hit or hold
	 * 
	 * @param hand : a Hand instance
	 * @return an action for a game (HIT or HOLD)
	 */
	public Action action(Hand hand) {

		return null;
	}

	/**
	 * Decides a player that a dealer is to defeat
	 */
	abstract void decideTarget();

}
