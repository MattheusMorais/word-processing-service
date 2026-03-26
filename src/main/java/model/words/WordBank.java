package model.words;

import model.utils.handlers.RandomHandler;
import model.utils.FileManager;
import java.util.List;

public class WordBank {
	List<String> wordList;

	public WordBank() {
		readWordFromBank();
	}

	public void readWordFromBank() {
		FileManager words = new FileManager();
		wordList = words.readWordBank();
	}

	public String returnWord() {
		int index = RandomHandler.nextInt(wordList.size());
		return wordList.get(index);
	}
}
