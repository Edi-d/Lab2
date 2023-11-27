package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect_db {

    private String user;
    private String password;

    public Connect_db(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");

            // Set the connection URL using Docker container name
            String url = "jdbc:postgresql://localhost:5432/virtual_guide";

            // Establish the connection
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");

            return conn;

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
