package model.game.shufflers;

/**
 * Embaralhador que inverte a palavra original.
 */
public class ReverseShuffler implements Shuffler {

	@Override
	public String shuffler(String word) {
		StringBuilder reversed = new StringBuilder();

		for (int i = word.length() - 1; i >= 0; i--) { // Algorithm that reverses the string
			char letter = word.charAt(i);
			reversed.append(letter);
		}
		return reversed.toString();
	}
}
