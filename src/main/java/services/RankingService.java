package services;

import model.dao.GameResultsDAO;
import model.game.results.GameResults;
import java.util.List;

/**
 * Serviço responsável pela lógica de finalização do jogo.
 * Calcula pontuação, adiciona informações ao resultado e persiste no banco de dados.
 */
public class RankingService {
    private final GameResultsDAO dao;

    public RankingService(GameResultsDAO dao) {
        this.dao = dao;
    }

    public List<GameResults> getRanking() {
       return dao.showRanking();
    }

    public void resetRanking() {
        dao.softDeleteAllScores();
        System.out.println("Histórico de pontuações 'deletado' com sucesso!");
    }

    public void restoreRanking() {
        dao.restoreAllScores();
        System.out.println("Histórico de pontuações restaurado com sucesso!");
    }
}
