package model.utils.handlers;

import java.util.Scanner;

public class InputHandler {
    private static final Scanner SC = new Scanner(System.in);

    /*
    Provides centralized access to Scanner for the entire project
    */

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
