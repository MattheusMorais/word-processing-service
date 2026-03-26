package controller;

import model.dao.GameResultsDAO;
import model.exceptions.ValidationException;
import model.game.results.GameResults;
import model.game.settings.MenuSettings;
import model.utils.handlers.InputHandler;
import model.game.mechanics.GameMechanic;
import model.game.mechanics.GameMechanicFactory;
import view.GameOverUI;
import view.MenuUI;
import java.sql.Connection;
import java.util.InputMismatchException;
import java.util.List;

public class GameController {
    private final GameResultsDAO gameResultsDAO;
    private final Connection conn;

    public GameController(GameResultsDAO gameResultsDAO, Connection conn) {
        this.gameResultsDAO = gameResultsDAO;
        this.conn = conn;

    }

    public void startGame() {
        boolean running = true;
        MenuUI menuUI = new MenuUI();

        while (running) {
            menuUI.showStartMenu();

            int mainOption;
            try {
                mainOption = InputHandler.nextInt();
                InputHandler.nextLine();
                MenuSettings.isOptionValid(mainOption);

            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite um número válido.");
                InputHandler.nextLine();
                continue;
            } catch (ValidationException e) {
                System.out.println(e.getMessage());
                continue;
            }

            if (mainOption == 2) {
                List<GameResults> ranking = gameResultsDAO.showRanking();
                if (ranking.isEmpty()) {
                    System.out.println("Não há pontuações, jogue uma partida :)");
                }
                for (GameResults result : ranking) {
                    System.out.println(result);
                }
                continue;
            }

            if (mainOption == 3) {
                gameResultsDAO.softDeleteScores();
                System.out.println("Ranking deletado!");
                continue;
            }

            if (mainOption == 4) {
                System.out.println("Fechando o jogo...");
                running = false;
                continue;
            }

            String playerName;
            while (true) {

                try {
                    System.out.println("Digite o nome do jogador: ");
                    playerName = InputHandler.nextLine();
                    MenuSettings.isPlayerNameValid(playerName);
                    break;
                } catch (ValidationException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Por favor, tente novamente.");
                }
            }

            int difficultyOption;
            while (true) {
                menuUI.showDifficultyMenu();

                try {
                    difficultyOption = InputHandler.nextInt();
                    InputHandler.nextLine();
                    MenuSettings.isDifficultyValid(difficultyOption);
                    break;
                } catch (InputMismatchException e1) {
                    InputHandler.nextLine();
                    System.out.println("Por favor, tente novamente.");
                } catch (ValidationException e1) {
                    System.out.println(e1.getMessage());
                    System.out.println("Por favor, tente novamente.");
                }
            }

            MenuSettings menuSettings = new MenuSettings(mainOption, playerName, difficultyOption);
            createGameMechanic(menuSettings);
        }
    }

    public void createGameMechanic(MenuSettings menuSettings) {
        GameMechanic gameMechanic = GameMechanicFactory.createMechanic();
        playGame(gameMechanic, menuSettings);
    }

    public void playGame(GameMechanic gameMechanic, MenuSettings menuSettings){
        GameResults gameResults = gameMechanic.play(menuSettings);
        String playerName = menuSettings.getPLAYERNAME();
        gameOver(gameResults, playerName);
    }

    public void gameOver(GameResults gameResults, String playerName) {
        if (gameResults.getHits() == 0 && gameResults.getMisses() == 0 && gameResults.getScore() == 0) {
            return;
        }

        this.gameResultsDAO.insert(gameResults, playerName);
        GameOverUI.gameOverUI(gameResults, playerName);
    }
}
