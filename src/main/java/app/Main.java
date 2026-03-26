package app;

import controller.GameController;
import model.dao.GameResultsDAO;
import model.utils.database.DatabaseConnection;
import model.utils.handlers.InputHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		runGame();
	}

	private static void runGame() throws SQLException {
		try(Connection conn = DatabaseConnection.getConnection()) {
			System.out.println("Conexão aberta com sucesso!");
			GameResultsDAO gameResultsDAO = new GameResultsDAO(conn);

			GameController gameController = new GameController(gameResultsDAO, conn);
			gameController.startGame();

			InputHandler.closeScanner();
		}
	}
}
