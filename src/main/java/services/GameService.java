package services;

import repository.GameResultsDAO;
import model.game.results.GameResults;
import utils.providers.DateTimeProvider;

/**
 * Serviço responsável pela lógica de finalização do jogo.
 * Calcula pontuação, adiciona informações ao resultado e persiste no banco.
 */
public class GameService {
    private final GameResultsDAO gameResultsDAO;

    public GameService(GameResultsDAO gameResultsDAO) {
        this.gameResultsDAO = gameResultsDAO;
    }

    /**
     * Finaliza o jogo e salva o resultado.
     *
     * @param gameResults resultado da partida
     * @param playerName nome do jogador
     */
    public void finishGame(GameResults gameResults, String playerName) {
        if (gameResults.getHits() == 0 && gameResults.getMisses() == 0) {
            return;
        }
        gameResults.setPlayerName(playerName);

        String timeFormatted = DateTimeProvider.getNow();
        gameResults.setTimeStampFormatted(timeFormatted);

        int score = gameResults.calculateScore();
        gameResults.setScore(score);

        gameResultsDAO.insert(gameResults);
    }
}
