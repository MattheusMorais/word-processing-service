package model.game.mechanics;

import model.game.results.GameResults;
import model.game.settings.MenuSettings;
import model.utils.handlers.InputHandler;
import model.words.WordBank;
import model.game.shufflers.Shuffler;
import model.game.shufflers.ShufflerFactory;

public abstract class BaseMechanic implements GameMechanic {
	GameResults currentGameResults = new GameResults();

	@Override
	public GameResults play(final MenuSettings settings) {
		WordBank bank = new WordBank();

		System.out.println("*** OBS: Digite 0 a qualquer momento para Finalizar o Jogo. ***");
		while (true) {
			String originalWord = bank.returnWord();
			Shuffler shuffler = ShufflerFactory.createShuffler(settings);

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
	protected abstract void processAnswer(String input, String originalWord);

}
