package controller;

import model.dao.GameResultsDAO;
import model.exceptions.ValidationException;
import model.game.mechanics.BaseMechanic;
import model.game.results.GameResults;
import model.game.settings.MenuSettings;
import model.utils.handlers.InputHandler;
import model.game.mechanics.GameMechanic;
import model.utils.handlers.LocalDateTimeHandler;
import view.GameOverUI;
import view.MenuUI;
import java.util.InputMismatchException;
import java.util.List;

public class GameController {
    private final GameResultsDAO gameResultsDAO;

    public GameController(GameResultsDAO gameResultsDAO) {
        this.gameResultsDAO = gameResultsDAO;

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
        String playerName = menuSettings.getPLAYERNAME();
        int difficulty = menuSettings.getDIFFICULTY();

        GameMechanic gameMechanic = new BaseMechanic(difficulty);
        playGame(gameMechanic, playerName);
    }

    public void playGame(GameMechanic gameMechanic, String playerName){
        GameResults gameResults = gameMechanic.play();
        gameOver(gameResults, playerName);
    }

    public void gameOver(GameResults gameResults, String playerName) {
        if (gameResults.getHits() == 0 && gameResults.getMisses() == 0 && gameResults.calculateScore() == 0) {
            return;
        }

        if (gameResults.getPlayerName() == null && gameResults.getTimeStampFormatted() == null && gameResults.getScore() == null) {
            gameResults.setPlayerName(playerName);

            String timeFormatted = LocalDateTimeHandler.getNow();
            gameResults.setTimeStampFormatted(timeFormatted);

            int score = gameResults.calculateScore();
            gameResults.setScore(score);
        }

        gameResultsDAO.insert(gameResults);
        GameOverUI.gameOverUI(gameResults);
    }
}
