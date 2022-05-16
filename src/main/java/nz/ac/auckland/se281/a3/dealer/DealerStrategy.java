package nz.ac.auckland.se281.a3.dealer;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;
import nz.ac.auckland.se281.a3.Player;

public abstract class DealerStrategy {

	protected Player target; // Dealer targets one Player and tries to defeat that Player

	/**
	 * Determines an Action of a Dealer for the round based on its target's current
	 * score.
	 * 
	 * @param dealerHand : a Hand instance of the Dealer
	 * @return an Action of the Dealer for the round
	 */
	public Action action(Hand dealerHand) {

		// Choose the target (the way of choosing is different to each DealerStrategy)
		// Re-choose the target before every time the Dealer actions
		decideTarget();

		// a Hand instance of the target
		Hand targetHand = target.getHand();

		// Dealer's action to defeat the target (Keep in mind that the game won't ask
		// the dealer to make a decision if the dealer's score is >= 21(including
		// blackjack)

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
	 * Determines which Player the Dealer tries to defeat for a round, and set the
	 * Player to the target field.
	 */
	public abstract void decideTarget();

}
