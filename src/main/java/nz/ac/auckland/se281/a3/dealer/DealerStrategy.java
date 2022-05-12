package nz.ac.auckland.se281.a3.dealer;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;
import nz.ac.auckland.se281.a3.Player;

public abstract class DealerStrategy {

	protected Player target;

	/**
	 * Determines an action of a dealer for a game based on its target's score.
	 * 
	 * @param dealerHand : a Hand instance of a dealer
	 * @return : an action of dealer for a game
	 */
	public Action action(Hand dealerHand) {
		Hand targetHand = target.getHand();
		if (targetHand.isBust()) {
			return Action.HOLD;
		} else if (targetHand.isBlackJack() && !dealerHand.isBlackJack()) {
			if (dealerHand.getScore() >= 17) {
				return Action.HOLD;
			} else {
				return Action.HIT;
			}
		} else if (targetHand.getScore() > dealerHand.getScore() && !dealerHand.isBust()) {
			return Action.HIT;
		}
		return Action.HOLD;
	}

	/**
	 * Determines the target that a dealer is to defeat
	 */
	public abstract void decideTarget();

}
