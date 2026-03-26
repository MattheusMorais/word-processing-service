package model.game.mechanics;

public class ScoreBaseMechanic extends BaseMechanic {

	@Override
	public final void processAnswer(String input, String originalWord) {
		if (input.equals(originalWord)) {
			currentGameResults.incrementHits(1); // +200 per hit
		} else {
			currentGameResults.incrementMisses(1); // -100 per miss
		}
	}

}
