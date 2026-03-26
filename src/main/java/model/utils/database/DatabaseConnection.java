package model.utils.database;

import model.exceptions.DbException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    public static Connection getConnection() {

        try {
            Properties props = loadProperties();

            String url = props.getProperty("dburl");

            return DriverManager.getConnection(url, props);
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

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
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

}
