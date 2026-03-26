package model.game.mechanics;

import model.game.results.GameResults;
import model.utils.handlers.InputHandler;
import model.words.WordBank;
import model.game.shufflers.Shuffler;
import model.game.shufflers.ShufflerFactory;

public class BaseMechanic implements GameMechanic {
	int difficulty;

	public BaseMechanic(int difficulty) {
		this.difficulty = difficulty;
	}

	GameResults currentGameResults = new GameResults();
	@Override
	public GameResults play() {
		WordBank bank = new WordBank();

		System.out.println("*** OBS: Digite 0 a qualquer momento para Finalizar o Jogo. ***");
		while (true) {
			String originalWord = bank.returnWord();
			Shuffler shuffler = ShufflerFactory.createShuffler(difficulty);

			String scrambledWord = shuffler.shuffler(originalWord);
			System.out.println("Palavra embaralhada: " + scrambledWord);
			System.out.println("Advinhe a palavra: ");

			String guess = InputHandler.nextLine();
			if (guess.equals("0")) {
				break;
			}

			processAnswer(guess, originalWord);

		}
		return currentGameResults;
	}

	@Override
	public final void processAnswer(String guess, String originalWord) {
		if (guess.equals(originalWord)) {
			currentGameResults.incrementHits(1);
		} else {
			currentGameResults.incrementMisses(1);
		}
	}

}
