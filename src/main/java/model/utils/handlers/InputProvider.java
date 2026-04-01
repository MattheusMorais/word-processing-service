package model.utils.handlers;

import java.util.Scanner;

public class InputProvider {
    /*
   Provides centralized access to Scanner for the entire project
   */

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
