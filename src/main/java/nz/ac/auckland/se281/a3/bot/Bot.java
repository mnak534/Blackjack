package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Player;

/**
 * you should change this class for TASK 1
 */

public class Bot extends Player {

	private BotStrategy strategy;

	public Bot(String name) {
		super(name);
	}

	/**
	 * a bot decides the action (HIT or HOLD) for a round
	 * 
	 * @param hand a Hand instance that belongs to this Bot
	 * @return Action(HIT/HOLD) that the Bot plays for the round
	 */
	@Override
	public Action decideAction(Hand hand) {
		return strategy.action(hand);
	}

	/**
	 * a bot decides the amount of a bet for a round
	 * 
	 * @return the amount of bet the Bot bets for the round
	 */
	@Override
	public int makeABet() {
		return strategy.bet();
	}

	/**
	 * Set the passed strategy as the strategy of this bot to play for the entire
	 * game
	 * 
	 * @param an instance of BotStrategy
	 */
	public void setBotStrategy(BotStrategy strategy) {
		this.strategy = strategy;
	}

}
