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
		decideTarget();
		System.out.println("The dealer's target: " + this.target.getName());
		Hand targetHand = target.getHand();

		// Dealer's action to defeat the target

		// If the target is busted, the dealer wins anyway, so HOLD
		if (targetHand.isBust()) {
			return Action.HOLD;
		}

		// If the target did blackjack, but the dealer did not,
		// Then it's impossible for the dealer to defeat the target.
		else if (targetHand.isBlackJack() && !dealerHand.isBlackJack()) {
			// In such a case, if the dealer's score is >= 17, the dealer HOLD
			if (dealerHand.getScore() >= 17) {
				return Action.HOLD;
			}
			// Otherwise, HIT
			else {
				return Action.HIT;
			}
		}

		// If the target's score is <= 21 AND is not blackjack
		else if (targetHand.getScore() <= 21 && !targetHand.isBlackJack()) {
			// The dealer HIT if the dealer's score < the target's score
			if (dealerHand.getScore() < targetHand.getScore()) {
				return Action.HIT;
			}
			// The dealer HOLD otherwise (already winning)
			else {
				return Action.HOLD;
			}
		}
		return Action.HOLD;
	}

	/**
	 * Determines the target that a dealer is to defeat
	 */
	public abstract void decideTarget();

}
