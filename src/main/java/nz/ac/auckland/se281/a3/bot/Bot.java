package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Player;

/**
 * you should change this class for TASK 1
 */

//the class that performs a strategy -> strategy.acrtion()

public class Bot extends Player {

	private static Strategy strategy;
	private Hand hand = this.getHand();

	public Bot(String name) {
		super(name);
	}

	@Override
	public Action decideAction(Hand hand) {
		return strategy.action();
	}

	@Override
	public int makeABet() {
		return strategy.bet();
	}

	public void strategyFactory(String strategy) {
		// factory here
		switch (strategy) {
		case "R":
			this.strategy = new RandomStrategy();
			break;
		case "LR":
			this.strategy = new LowRiskStrategy(hand);
			break;
		case "HR":
			this.strategy = new HighRiskStrategy(hand);
			break;
		}
	}

}
