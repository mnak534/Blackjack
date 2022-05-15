package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.Player;

public class TargetTopWinner extends DealerStrategy {

	private List<Player> players;

	/**
	 * Constructor for TargetTopWinner. Takes a list of Players in a game as a
	 * parameter, and set it to this players field.
	 * 
	 * @param players : a list of Players in a game
	 */
	public TargetTopWinner(List<Player> players) {
		this.players = players;
	}

	/**
	 * Determine who has the highest net wins at the moment, and set that Player to
	 * be the target of the DealerStrategy
	 */
	@Override
	public void decideTarget() {

		// temporarily set the first Player in the list to be the topPlayer
		Player topPlayer = players.get(0);

		// Loop through each player to find who have won the most
		for (int i = 1; i < players.size(); i++) {

			// if other player won more than the topPlayer, set that player to be the
			// new topPlayer
			if (topPlayer.getNetWins() < players.get(i).getNetWins()) {
				topPlayer = players.get(i);
			}
		}

		// Set the Player who won the most to be the Dealer's target
		this.target = topPlayer;
	}

}
