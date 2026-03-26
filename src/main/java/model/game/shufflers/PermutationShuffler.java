package model.game.shufflers;

import model.utils.handlers.RandomHandler;

public class PermutationShuffler implements Shuffler {

	@Override
	public String shuffler(String word) {
		char[] chosenWord = word.toCharArray();

		for (int i = chosenWord.length - 1; i > 0; i--) { // Algorithm that randomly swaps characters in the array
			int j = RandomHandler.nextInt(i + 1);
			char temp = chosenWord[i];
			chosenWord[i] = chosenWord[j];
			chosenWord[j] = temp;
		}
		return new String(chosenWord);
	}
}
