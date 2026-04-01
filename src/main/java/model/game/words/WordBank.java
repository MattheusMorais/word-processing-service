package model.game.words;

import utils.providers.RandomProvider;
import utils.FileManager;
import java.util.List;

/**
 * Gerencia o conjunto de palavras do jogo.
 */
public class WordBank {
	private List<String> wordList;

	public WordBank() {
		readWordFromBank();
	}

	public void readWordFromBank() {
		FileManager words = new FileManager();
		wordList = words.readWordBank();
	}

	public String returnWord() {
		int index = RandomProvider.nextInt(wordList.size());
		return wordList.get(index);
	}
}
