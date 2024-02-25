package main.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que gestiona la conexión a la base de datos SQLite.
 */
public class ConnectionDB {

    private static ConnectionDB instance;
    private Connection connection;
    private String jdbcUrl = "jdbc:sqlite:src/resources/database.db";

    /**
     * Constructor privado para evitar instanciación externa.
     * Se encarga de establecer la conexión con la base de datos.
     */
    private ConnectionDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(jdbcUrl);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método estático que proporciona la instancia única de ConnectionDB.
     *
     * @return La instancia única de ConnectionDB.
     */
    public static ConnectionDB getInstance() {
        if (instance == null) {
            instance = new ConnectionDB();
        }
        return instance;
    }

    /**
     * Método para obtener la conexión a la base de datos.
     *
     * @return La conexión a la base de datos.
     */
    public Connection getConnection() {
        return connection;
    }
}
