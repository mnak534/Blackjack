package nz.ac.auckland.se281.a3.bot;

public class BotStrategyFactory {

	/**
	 * Create a BotStrategy instance depending on a user's choice. Set the bot's
	 * strategy to the specified strategy
	 * 
	 * @param strategy : string indicates which bot strategy a user wants the bots
	 *                 to play.
	 */
	public static BotStrategy setSBotStrategy(String strategy) {
		// BotStrategy factory based on the user input
		switch (strategy) {
		case "R":
			return new RandomStrategy();
		case "LR":
			return new LowRiskStrategy();
		case "HR":
			return new HighRiskStrategy();
		default:
			return null;
		}
	}

}
