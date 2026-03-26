package model.game.mechanics;

public class ErrorBaseMechanic extends BaseMechanic {
    
	@Override
	public final void processAnswer(String input, String originalWord) {
		if (input.equals(originalWord)) {
            currentGameResults.incrementHits(1);
		} else {
			currentGameResults.incrementMisses(1);
		}
	}

}
