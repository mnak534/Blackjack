package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.BlackJack;
import nz.ac.auckland.se281.a3.Player;

public class TargetTopWinner extends DealerStrategy {

	private BlackJack game;

	/**
	 * Constructor for TargetTopWinner.
	 * 
	 * @param game : an instance of BlackJack
	 */
	public TargetTopWinner(BlackJack game) {
		decideTarget();
		this.game = game;
	}

	/**
	 * Determine who has the highest net wins at the moment
	 */
	@Override
	public void decideTarget() {
		// Get a list of players participating in a game
		List<Player> players = game.getPlayers();

		Player topPlayer = players.get(0);

		// Loop through each player to find who have won the most
		for (int i = 1; i < players.size(); i++) {
			if (topPlayer.getNetWins() < players.get(i).getNetWins()) {
				topPlayer = players.get(i);
			}
		}
		this.target = topPlayer;
	}

}
