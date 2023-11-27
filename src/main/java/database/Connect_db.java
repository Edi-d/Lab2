package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect_db {

    private String url;
    private String user;
    private String password;

    public Connect_db(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");

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
