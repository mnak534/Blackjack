package nz.ac.auckland.se281.a3.dealer;

import nz.ac.auckland.se281.a3.BlackJack;
import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public class HighestBidderStrategy extends DealerStrategy {

	/**
	 * Constructor for HighestBidderStrategy
	 */
	public HighestBidderStrategy(BlackJack game) {
		// Determine which player has the highest bet
		super(game);
	}

	@Override
	public Action action(Hand hand) {
		return null;
	}

	@Override
	void decideTarget() {
		// TODO Auto-generated method stub

	}
}
