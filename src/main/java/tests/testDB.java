package tests;


import database.Connect_db;
import org.junit.jupiter.api.Test;

import repository.CustomerDatabaseRepository;

import java.sql.Connection;
import java.sql.SQLException;

public class testDB {

    private Connect_db db_connection;
    private CustomerDatabaseRepository customerDatabaseRepository;

    @Test
    void test_connection() throws SQLException {
        db_connection = new Connect_db("jdbc:postgresql://localhost:5432/virtual_guide","admin", "S3cret");
        Connection db = db_connection.connect();
        System.out.println(db);

        customerDatabaseRepository = new CustomerDatabaseRepository();

        customerDatabaseRepository.addCustomer(db, "John", "Doe", 25, "jon@main.com");
        customerDatabaseRepository.deleteCustomer(db, 1);
    }

}