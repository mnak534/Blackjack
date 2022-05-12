package nz.ac.auckland.se281.a3.dealer;

import nz.ac.auckland.se281.a3.BlackJack;
import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public class TopWinnerStrategy extends DealerStrategy {

	/**
	 * Constructor for TopWinnerStrategy
	 */
	public TopWinnerStrategy(BlackJack game) {
		// Determine which player has the highest net win
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
