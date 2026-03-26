package model.game.shufflers;

public class ShufflerFactory {

	public static Shuffler createShuffler(int difficulty) {
        return switch (difficulty) {
            case 1 -> new ReverseShuffler();
            case 2 -> new PermutationShuffler();
            default -> new ReverseShuffler();
        };
	}
}
