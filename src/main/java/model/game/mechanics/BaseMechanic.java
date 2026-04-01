package model.game.mechanics;

import model.game.results.GameResults;
import utils.providers.InputProvider;
import model.game.words.WordBank;
import model.game.shufflers.Shuffler;
import model.game.shufflers.ShufflerFactory;

/**
 * Implementação base da mecânica do jogo.
 * Controla o fluxo da partida e compara respostas do jogador.
 */
public class BaseMechanic implements GameMechanic {
	private final WordBank bank = new WordBank();
	private final GameResults currentGameResults = new GameResults();
	int difficulty;

	public BaseMechanic(int difficulty) {
		this.difficulty = difficulty;
	}

	/**
	 * Executa a lógica principal do jogo.
	 *
	 * @return resultado da partida
	 */
	@Override
	public GameResults play() {
		System.out.println("*** OBS: Digite 0 a qualquer momento para Finalizar o Jogo. ***");
		while (true) {
			String originalWord = bank.returnWord();
			Shuffler shuffler = ShufflerFactory.createShuffler(difficulty);

			String scrambledWord = shuffler.shuffler(originalWord);
			System.out.println("Palavra embaralhada: " + scrambledWord);
			System.out.println("Advinhe a palavra: ");

			String guess = InputProvider.nextLine();
			if (guess.equals("0")) {
				break;
			}
			processAnswer(guess, originalWord);
		}
		return currentGameResults;
	}

	/**
	 * Processa a resposta do jogador.
	 *
	 * @param guess resposta do jogador
	 * @param originalWord palavra correta
	 */
	@Override
	public final void processAnswer(String guess, String originalWord) {
		if (guess.equals(originalWord)) {
			currentGameResults.incrementHits(1);
		} else {
			currentGameResults.incrementMisses(1);
		}
	}
}
