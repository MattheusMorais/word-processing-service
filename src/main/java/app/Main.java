package app;

import controller.GameController;
import repository.GameResultsDAO;
import config.DatabaseConnection;
import utils.providers.InputProvider;
import services.GameService;
import services.RankingService;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Classe principal da aplicação.
 * Responsável por inicializar os componentes e iniciar o jogo.
 */
public class Main {

	public static void main(String[] args) throws SQLException {
		runGame();
	}

	private static void runGame() throws SQLException {
		try(Connection conn = DatabaseConnection.getConnection()) {
			System.out.println("Conexão aberta com sucesso!");
			GameResultsDAO gameResultsDAO = new GameResultsDAO(conn);

			RankingService rankingService = new RankingService(gameResultsDAO);
			GameService gameService = new GameService(gameResultsDAO);

			GameController gameController = new GameController(rankingService, gameService);
			gameController.startGame();

			InputProvider.closeScanner();
		}
	}
}
