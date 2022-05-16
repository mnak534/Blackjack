package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.Player;

public class TargetHighestBidder extends DealerStrategy {

	private List<Player> players;

	/**
	 * Constructor for TargetHighestBidder. Takes a list of Players in a game as a
	 * parameter, and set it to this players field.
	 * 
	 * @param players : a list of Players in a game
	 */
	public TargetHighestBidder(List<Player> players) {
		this.players = players;
	}

	/**
	 * Determines who's the highest bidder for the round, and set that Player to be
	 * the DealerStrategy's target
	 */
	@Override
	public void decideTarget() {

		// temporarily set the first Player in the list to be the highestBidder
		Player highestBidder = players.get(0);

		// Loop through each player to find who bets the most
		for (int i = 1; i < players.size(); i++) {
			// if other player bet more than the highestPlayer, set that player to be the
			// new highestBidder
			if (highestBidder.getHand().getBet() < players.get(i).getHand().getBet()) {
				highestBidder = players.get(i);
			}
		}

		// Set the Player who bet the most to be the Dealer's target
		this.target = highestBidder;
	}

}
