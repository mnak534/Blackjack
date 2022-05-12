package nz.ac.auckland.se281.a3.dealer;

import nz.ac.auckland.se281.a3.BlackJack;

public class TopWinnerStrategy extends DealerStrategy {

	private BlackJack game;

	/**
	 * Constructor for TopWinnerStrategy.
	 * 
	 * @param game : an instance of BlackJack
	 */
	public TopWinnerStrategy(BlackJack game) {
		this.game = game;
	}

	/**
	 * Determine who has the highest net wins at the moment
	 */
	@Override
	public void decideTarget() {
		// TODO Auto-generated method stub

	}

}
