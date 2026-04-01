package model.utils.handlers;

import java.util.Scanner;

/**
 * Classe utilitária que centraliza a leitura de entrada do usuário.
 */
public class InputProvider {
    private static final Scanner SC = new Scanner(System.in);

    public static int nextInt() {
        return SC.nextInt();
    }

    public static double nextDouble() {
        return SC.nextDouble();
    }

    public static String next() {
        return SC.next();
    }

    public static String nextLine() {
        return SC.nextLine();
    }

    public static void closeScanner() {
        SC.close();
    }
}
