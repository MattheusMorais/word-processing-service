package services;

import model.dao.GameResultsDAO;
import model.game.results.GameResults;
import model.utils.handlers.DateTimeProvider;

/**
 * Serviço responsável pela lógica de finalização do jogo.
 * Calcula pontuação, adiciona informações ao resultado e persiste no banco de dados.
 */
public class GameService {
    private final GameResultsDAO gameResultsDAO;

    public GameService(GameResultsDAO gameResultsDAO) {
        this.gameResultsDAO = gameResultsDAO;
    }

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
