package nz.ac.auckland.se281.a3.bot;

public class BotStrategyFactory {

	/**
	 * Create a BotStrategy instance depending on a user's choice. Set the bot's
	 * strategy to the specified strategy
	 * 
	 * @param strategy : string that indicates which bot strategy a user wants the
	 *                 bots to play.
	 * @return an instance of BotStrategy of the user's choice
	 */
	public static BotStrategy createBotStrategy(String strategy) {
		// BotStrategy factory based on the user input
		switch (strategy) {
		// if R is entered by a user, bots perform the random strategy
		case "R":
			return new RandomStrategy();
		// if LR is entered by a user, bots perform the low-risk strategy
		case "LR":
			return new LowRiskStrategy();
		// if HR is entered by a user, bots perform the high-risk strategy
		case "HR":
			return new HighRiskStrategy();
		default:
			return null;
		}
	}

}
