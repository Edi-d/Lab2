package tests;

import database.Connect_db;
import dbRepo.GuideRepo;
import domain.Guide;
import domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import dbRepo.CustomerRepo;
import domain.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class testDB {

    private Connect_db dbConnection;
    private CustomerRepo customerDatabaseRepository;
    private GuideRepo gudiesDatabaseRepository;

    @BeforeEach
    void setUp() {
        // Initialize your database connection here if needed
        dbConnection = new Connect_db("jdbc:postgresql://localhost:5432/virtual_guide", "admin", "S3cret");
        customerDatabaseRepository = new CustomerRepo();
        gudiesDatabaseRepository = new GuideRepo();
    }

    @Test
    void testConnection() throws SQLException {
        Connection db = dbConnection.connect();
        assertNotNull(db, "Connection should not be null");
    }

    @Test
    void addCustomer() throws SQLException {
        Connection db = dbConnection.connect();
        assertNotNull(db, "Connection should not be null");

        Customer customer = new Customer(1, "John", "Doe", 25, "jondoe@mail.com");

        // Adding the customer to the database
        customerDatabaseRepository.addCustomer(db, customer.getFirstName(), customer.getLastName(),
                customer.getAge(), customer.getEmail());
    }

    @Test
    void deleteCustomer() throws SQLException {
        Connection db = dbConnection.connect();
        assertNotNull(db, "Connection should not be null");

        customerDatabaseRepository.deleteCustomer(db, 1);
    }

    @Test
    void getCustomer() throws SQLException {
        Connection db = dbConnection.connect();
        assertNotNull(db, "Connection should not be null");

        List<Object[]> costumers =  customerDatabaseRepository.getCustomer(db, 3);
        assertNotNull(costumers, "Costumers should not be null");
        assertEquals(costumers.size(), 0, "Costumers should not be empty");

        costumers =  customerDatabaseRepository.getCustomer(db, 4);
        assertNotEquals(costumers.size(), 0, "Costumers should not be empty");
    }


    @Test
    void addGuide() throws SQLException {
        Connection db = dbConnection.connect();
        assertNotNull(db, "Connection should not be null");

        Guide guide = new Guide(1, "John", "Doe", 25, "jondoe@mail.com");

        gudiesDatabaseRepository.addGuide(db, guide.getFirstName(), guide.getLastName(), guide.getAge(), guide.getEmail());
    }

    @Test
    void deleteGuide() throws SQLException {
        Connection db = dbConnection.connect();
        assertNotNull(db, "Connection should not be null");

        gudiesDatabaseRepository.deleteGuide(db, 1);
    }

    @Test
    void getGuide() throws SQLException {
        Connection db = dbConnection.connect();
        assertNotNull(db, "Connection should not be null");

        List<Object[]> costumers =  gudiesDatabaseRepository.getGuide(db, 1);
        assertNotNull(costumers, "Costumers should not be null");
        assertEquals(costumers.size(), 0, "Costumers should not be empty");

        costumers =  gudiesDatabaseRepository.getGuide(db, 2);
        assertNotEquals(costumers.size(), 0, "Costumers should not be empty");
    }

    @Test
    void generalTest() throws SQLException {
        Connection db = dbConnection.connect();
        assertNotNull(db, "Connection should not be null");

        Customer customer = new Customer(1, "John", "Doe", 25, "johndoe@mail.com");
        customerDatabaseRepository.addCustomer(db, customer.getFirstName(), customer.getLastName(),
                customer.getAge(), customer.getEmail());


    }

}
