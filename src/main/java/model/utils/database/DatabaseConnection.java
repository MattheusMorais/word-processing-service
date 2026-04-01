package model.utils.database;

import model.exceptions.DbException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

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
            Properties props = loadProperties();

            String url = props.getProperty("dburl");

            return DriverManager.getConnection(url, props);
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    /**
     * Carrega as propriedades de configuração do banco.
     *
     * @return propriedades carregadas
     * @throws DbException se o arquivo não for encontrado ou ocorrer erro de leitura
     */
    public static Properties loadProperties() {
        try {
            try(InputStream is = DatabaseConnection.class.getClassLoader().getResourceAsStream("database/db.properties")) {
                if (is == null) {
                    throw new DbException("Arquivo db.properties não encontrado no classpath.");
                }
                Properties props = new Properties();
                props.load(is);
                return props;
            }
        }
        catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }
}
