package model.dao;

import model.exceptions.DbException;
import model.game.results.GameResults;
import model.utils.handlers.LocalDateTimeHandler;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameResultsDAO {
    private Connection conn;

    public GameResultsDAO(Connection conn) {
        this.conn = conn;
    }

    public void insert(GameResults results, String playerName)  {

        try (PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO results (playername, hits, misses, score) VALUES (?,?,?,?)"
        )) {
            ps.setString(1, playerName);
            ps.setInt(2, results.getHits());
            ps.setInt(3, results.getMisses());
            ps.setInt(4, results.getScore());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public List<GameResults> showRanking() {
        List<GameResults> ranking = new ArrayList<>();

        try(PreparedStatement ps = conn.prepareStatement(
                "SELECT playername, hits, misses, score, created_at " +
                        "FROM results WHERE deleted = false " +
                        "ORDER BY score DESC"
        )) {
            try(ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    String playerName = rs.getString("playername");
                    Integer hits = rs.getInt("hits");
                    Integer misses = rs.getInt("misses");
                    Integer score = rs.getInt("score");
                    Timestamp datetime = rs.getTimestamp("created_at");

                    String dateTimeFormatted = LocalDateTimeHandler.formatTimeStamp(datetime);

                    GameResults result = new GameResults(playerName, hits, misses, score, dateTimeFormatted);

                    ranking.add(result);
                }

                return ranking;

            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public void softDeleteScores() {

        try(PreparedStatement ps = conn.prepareStatement(
                "UPDATE results " +
                        "SET deleted = true " +
                        "WHERE deleted = false"
        )) {
            int rowsAffected = ps.executeUpdate();
            System.out.println(rowsAffected + " linhas deletadas.");
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
}
