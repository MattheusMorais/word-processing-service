package model.game.mechanics;

import model.game.results.GameResults;

/**
 * Interface que define o comportamento de uma mecânica de jogo.
 */
public interface GameMechanic {
	GameResults play();
	void processAnswer(String input, String originalWord);
}
