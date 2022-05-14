package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Player;

/**
 * you should change this class for TASK 1
 */

//the class that performs a strategy -> strategy.acrtion()

public class Bot extends Player {

	private BotStrategy strategy;

	public Bot(String name) {
		super(name);
	}

	/**
	 * a bot decides the action (HIT or HOLD) for a game
	 */
	@Override
	public Action decideAction(Hand hand) {
		return strategy.action(hand);
	}

	/**
	 * a bot decides the amount of a bet for a game
	 */
	@Override
	public int makeABet() {
		return strategy.bet();
	}

	public void setBotStrategy(BotStrategy strategy) {
		this.strategy = strategy;
	}

}
