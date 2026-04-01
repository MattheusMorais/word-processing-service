package repository;

import exceptions.DbException;
import model.game.results.GameResults;
import utils.providers.DateTimeProvider;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de acesso a dados (DAO) para resultados de jogos.
 * Responsável por interagir diretamente com o banco de dados.
 */
public class GameResultsDAO {
    private Connection conn;

    public GameResultsDAO(Connection conn) {
        this.conn = conn;
    }

    /**
     * Insere um novo resultado no banco de dados.
     *
     * @param results resultado da partida a ser persistido
     * @throws DbException se ocorrer erro ao acessar o banco
     */
    public void insert(GameResults results)  {
        try (PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO results (playername, hits, misses, score) VALUES (?,?,?,?)"
        )) {
            ps.setString(1, results.getPlayerName());
            ps.setInt(2, results.getHits());
            ps.setInt(3, results.getMisses());
            ps.setInt(4, results.calculateScore());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    /**
     * Retorna o ranking dos melhores jogadores.
     *
     * @return lista com os resultados ordenados por pontuação
     * @throws DbException se ocorrer erro ao acessar o banco
     */
    public List<GameResults> showRanking() {
        List<GameResults> ranking = new ArrayList<>();

        try(PreparedStatement ps = conn.prepareStatement(
                "SELECT playername, hits, misses, score, created_at " +
                        "FROM results WHERE deleted = false " +
                        "ORDER BY score DESC " +
                        "LIMIT 5"
        )) {
            try(ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    String playerName = rs.getString("playername");
                    Integer hits = rs.getInt("hits");
                    Integer misses = rs.getInt("misses");
                    Integer score = rs.getInt("score");
                    Timestamp datetime = rs.getTimestamp("created_at");

                    String dateTimeFormatted = DateTimeProvider.formatTimeStamp(datetime);

                    GameResults result = new GameResults(playerName, hits, misses, score, dateTimeFormatted);

                    ranking.add(result);
                }
                return ranking;
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    /**
     * Marca todas as pontuações como deletadas (soft delete).
     *
     * @throws DbException se ocorrer erro ao acessar o banco
     */
    public void softDeleteAllScores() {
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

    /**
     * Restaura pontuações previamente deletadas.
     *
     * @throws DbException se ocorrer erro ao acessar o banco
     */
    public void restoreAllScores() {
        try (PreparedStatement ps = conn.prepareStatement(
                "UPDATE results " +
                        "SET deleted = false " +
                        "WHERE deleted = true"
        )) {
            int rowsAffected = ps.executeUpdate();
            System.out.println(rowsAffected + " linhas recuperadas.");
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
}
