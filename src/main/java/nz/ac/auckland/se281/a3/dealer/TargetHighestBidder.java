package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.Player;

public class TargetHighestBidder extends DealerStrategy {

	private List<Player> players;

	/**
	 * Constructor for TargetHighestBidder.
	 * 
	 * @param game : an instance of BlackJack
	 */
	public TargetHighestBidder(List<Player> players) {
		this.players = players;
	}

	/**
	 * Determines who's the highest bidder for a round
	 */
	@Override
	public void decideTarget() {

		Player highestPlayer = players.get(0);

		// Loop through each player to find who bets the hgihest
		for (int i = 1; i < players.size(); i++) {
			if (highestPlayer.getHand().getBet() < players.get(i).getHand().getBet()) {
				highestPlayer = players.get(i);
			}
		}
		this.target = highestPlayer;
	}

}
