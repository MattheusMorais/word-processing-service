package model.game.mechanics;

import model.utils.handlers.RandomHandler;

public class GameMechanicFactory {

	public static GameMechanic createMechanic() {

		if (RandomHandler.nextBoolean()) {
			return new ErrorBaseMechanic();
		} else {
			return new ScoreBaseMechanic();
		}
	}
}
