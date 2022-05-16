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

	/**
	 * a Dealer decides the action (HIT or HOLD) for the round
	 * 
	 * @param hand : a Hand instance that belongs to the Dealer
	 * @return Action(HIT/HOLD) that the Dealer plays for the round
	 */
	@Override
	public Action decideAction(Hand hand) {
		return strategy.action(hand);
	}

	/**
	 * Set the passed DealerStrategy instance as the strategy that this Dealer plays
	 * until the strategy is updated again.
	 * 
	 * @param strategy : a DealerStrategy instance
	 */
	public void setDealerStrategy(DealerStrategy strategy) {
		this.strategy = strategy;
	}

}
