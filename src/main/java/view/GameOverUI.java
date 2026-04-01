package view;

import model.game.results.GameResults;

/**
 * Responsável por exibir o resultado final do jogo.
 */
public class GameOverUI {

    public static void gameOverUI(GameResults gameResults) {
        System.out.println("Resultado do jogo: \n" + gameResults);
    }
}
