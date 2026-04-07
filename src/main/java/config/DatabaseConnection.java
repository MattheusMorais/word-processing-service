package config;

import exceptions.DbException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Responsável por fornecer conexões com o banco de dados.
 * Utiliza propriedades definidas em arquivo externo.
 */
public class DatabaseConnection {
    /**
     * Obtém uma conexão com o banco de dados.
     *
     * @return conexão ativa
     * @throws DbException se ocorrer erro ao conectar
     */
    public static Connection getConnection() {
        try {
            String host = System.getenv().getOrDefault("DB_HOST", "localhost");
            String port = System.getenv().getOrDefault("DB_PORT", "5432");
            String db = System.getenv("DB_NAME");

            String url = "jdbc:postgresql://" + host + ":" + port + "/" + db;

            String user = System.getenv("DB_USER");
            String password = System.getenv("DB_PASSWORD");

            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
}
