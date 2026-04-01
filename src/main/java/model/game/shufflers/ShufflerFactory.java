package model.game.shufflers;

/**
 * Fábrica responsável por criar embaralhadores com base na dificuldade.
 */
public class ShufflerFactory {

	public static Shuffler createShuffler(int difficulty) {
        return switch (difficulty) {
            case 1 -> new ReverseShuffler();
            case 2 -> new PermutationShuffler();
            default -> new ReverseShuffler();
        };
	}
}
