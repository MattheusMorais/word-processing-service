package controller;

import model.exceptions.ValidationException;
import model.game.mechanics.BaseMechanic;
import model.game.results.GameResults;
import model.game.validators.MenuValidator;
import model.utils.handlers.InputProvider;
import model.game.mechanics.GameMechanic;
import services.GameService;
import services.RankingService;
import view.GameOverUI;
import view.MenuUI;
import java.util.InputMismatchException;
import java.util.List;

public class GameController {
    private final RankingService rankingService;
    private final GameService gameService;
    private final MenuUI menuUI = new MenuUI();
    private boolean isRunning = true;

    public GameController(RankingService rankingService, GameService gameService) {
        this.rankingService = rankingService;
        this.gameService = gameService;
    }

    public void startGame() {

        while (isRunning) {
            menuUI.showStartMenu();
            int mainOption;
            try {
                mainOption = InputProvider.nextInt();
                InputProvider.nextLine();
                MenuValidator.isOptionValid(mainOption);
            }
            catch (InputMismatchException e) {
                System.out.println("Erro: Digite um número válido.");
                InputProvider.nextLine();
                continue;
            }
            catch (ValidationException e) {
                System.out.println(e.getMessage());
                continue;
            }

            switch(mainOption) {
                case 2:
                    showRanking();
                    continue;
                case 3:
                    handleReset();
                    continue;
                case 4:
                    handleRestore();
                    continue;
                case 5:
                    closeGame();
                    continue;
            }

            String playerName;
            while (true) {
                try {
                    System.out.println("Digite o nome do jogador: ");
                    playerName = InputProvider.nextLine();
                    MenuValidator.isPlayerNameValid(playerName);
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
                    difficultyOption = InputProvider.nextInt();
                    InputProvider.nextLine();
                    MenuValidator.isDifficultyValid(difficultyOption);
                    break;
                } catch (InputMismatchException e1) {
                    InputProvider.nextLine();
                    System.out.println("Por favor, tente novamente.");
                } catch (ValidationException e1) {
                    System.out.println(e1.getMessage());
                    System.out.println("Por favor, tente novamente.");
                }
            }
            GameMechanic gameMechanic = new BaseMechanic(difficultyOption);
            GameResults gameResults = gameMechanic.play();
            gameService.finishGame(gameResults, playerName);
            GameOverUI.gameOverUI(gameResults);
        }
    }

    private void showRanking() {
        List<GameResults> ranking = rankingService.getRanking();
        if (ranking.isEmpty()) {
            System.out.println("Não há pontuações, jogue uma partida :)");
        }
        ranking.forEach(System.out::println);
    }

    private void handleReset() {
        if (menuUI.confirmReset()) {
            rankingService.resetRanking();
        } else {
            System.out.println("Ação cancelada! Retornando ao menu inicial...");
        }
    }

    private void handleRestore() {
        rankingService.restoreRanking();
    }

    private void closeGame() {
        System.out.println("Jogo encerrado. Obrigado por jogar!");
        isRunning = false;
    }
}
