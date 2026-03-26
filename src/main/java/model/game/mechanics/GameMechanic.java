package model.game.mechanics;

import model.game.results.GameResults;

public interface GameMechanic {
	GameResults play();
	void processAnswer(String input, String originalWord);
}
