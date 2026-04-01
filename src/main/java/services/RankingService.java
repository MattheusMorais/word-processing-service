package services;

import repository.GameResultsDAO;
import model.game.results.GameResults;
import java.util.List;

/**
 * Serviço responsável pelas operações relacionadas ao ranking.
 */
public class RankingService {
    private final GameResultsDAO dao;

    public RankingService(GameResultsDAO dao) {
        this.dao = dao;
    }

    /**
     * Retorna o ranking dos melhores jogadores.
     *
     * @return lista com os melhores resultados
     */
    public List<GameResults> getRanking() {
       return dao.showRanking();
    }

    /**
     * Reseta (soft delete) todas as pontuações.
     */
    public void resetRanking() {
        dao.softDeleteAllScores();
        System.out.println("Histórico de pontuações 'deletado' com sucesso!");
    }

    /**
     * Restaura pontuações previamente removidas.
     */
    public void restoreRanking() {
        dao.restoreAllScores();
        System.out.println("Histórico de pontuações restaurado com sucesso!");
    }
}
