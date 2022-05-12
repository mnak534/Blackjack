package nz.ac.auckland.se281.a3.dealer;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;
import nz.ac.auckland.se281.a3.Player;

public abstract class DealerStrategy {

	// Instance fields
	protected Player target;

	/**
	 * Constructor for DealerStrategy
	 * 
	 * @param target a certain Player that a dealer is to defeat
	 */
	public DealerStrategy(Player target) {
		this.target = target;
	}

	/**
	 * Decides whether hit or hold
	 * 
	 * @param hand : a Hand instance
	 * @return an action for a game (HIT or HOLD)
	 */
	abstract Action action(Hand hand);
}
