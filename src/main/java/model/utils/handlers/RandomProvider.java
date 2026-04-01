package model.utils.handlers;

import java.util.Random;

/**
 * Classe utilitária para geração de valores aleatórios.
 */
public class RandomProvider {
    private static final Random random = new Random();

    public static int nextInt() {
        return random.nextInt();
    }

    public static boolean  nextBoolean() {
        return random.nextBoolean();
    }

    public static int nextInt(int size) {
        return random.nextInt(size);
    }
}
