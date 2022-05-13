package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.Player;

public class TargetTopWinner extends DealerStrategy {

	private List<Player> players;

	/**
	 * Constructor for TargetTopWinner.
	 * 
	 * @param game : an instance of BlackJack
	 */
	public TargetTopWinner(List<Player> players) {
		this.players = players;
	}

	/**
	 * Determine who has the highest net wins at the moment
	 */
	@Override
	public void decideTarget() {
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
