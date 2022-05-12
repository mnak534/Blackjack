package nz.ac.auckland.se281.a3.dealer;

import nz.ac.auckland.se281.a3.BlackJack;

public class HighestBidderStrategy extends DealerStrategy {

	private BlackJack game;

	/**
	 * Constructor for HighestBidderStrategy.
	 * 
	 * @param game : an instance of BlackJack
	 */
	public HighestBidderStrategy(BlackJack game) {
		this.game = game;
	}

	/**
	 * Determines who's the highest bidder for a round
	 */
	@Override
	public void decideTarget() {
		// TODO Auto-generated method stub

	}

}
