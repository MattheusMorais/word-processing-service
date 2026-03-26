package model.dao;

import model.exceptions.DbException;
import model.game.results.GameResults;
import model.utils.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GameResultsDAO {

    public GameResultsDAO() {}

    public void insert(GameResults results, String playerName)  {
        try(Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO results (playername, hits, misses, score) VALUES (?,?,?,?)"
            ); // SELECT * from results ORDER by score DESC;
            // Setar Dependências no Maven(Driver JDBC jar)

            ps.setString(1, playerName);
            ps.setInt(2, results.getHits());
            ps.setInt(3, results.getMisses());
            ps.setInt(4, results.getScore());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }
}
