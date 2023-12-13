package org.example;
import database.Connect_db;
import dbRepo.CustomerRepo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
//        Connect_db dbConnection = new Connect_db("jdbc:postgresql://localhost:5432/virtual_guide", "admin", "S3cret");
//        CustomerRepo customerDatabaseRepository = new CustomerRepo();
//
//        Connection db = dbConnection.connect();
//        assertNotNull(db, "Connection should not be null");
//
//        List<Object[]> costumers =  customerDatabaseRepository.getCustomer(db, 4);
//        if (costumers.size() == 0) System.out.println("No costumer found");
//        else {
//            for (Object[] costumer : costumers) {
//                System.out.println("ID: " + costumer[0] + ", firstname: " + costumer[1] + ", lastname: " + costumer[2] + ", age: " + costumer[3] + ", email: " + costumer[4]);
//            }
//        }

        SpringApplication.run(Main.class, args);

    }


}