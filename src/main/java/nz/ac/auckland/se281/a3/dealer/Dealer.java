package nz.ac.auckland.se281.a3.dealer;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant;

/**
 * 
 * You should change this class for Task 2
 *
 */
public class Dealer extends Participant {

	private DealerStrategy strategy;

	public Dealer(String name) {
		super(name);
	}

	@Override
	public Action decideAction(Hand hand) {
		return strategy.action(hand);
	}

	/**
	 * Set a specified strategy that a dealer plays.
	 * 
	 * @param strategy : a DealerStrategy instance
	 */
	public void setDealerStrategy(DealerStrategy strategy) {
		this.strategy = strategy;
	}

}
