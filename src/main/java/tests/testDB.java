package tests;


import database.Connect_db;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class testDB {

    private Connect_db db_connection;

    @Test
    void test_connection() {
        db_connection = new Connect_db("jdbc:postgresql://localhost:5432/virtual_guide","admin", "S3cret");
        Connection db = db_connection.connect();
        System.out.println(db);
    }

}