package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public interface BotStrategy {

	// Decidets whether hit or hold
	Action action(Hand hand);

	// Decide the bet amount
	int bet();
}
