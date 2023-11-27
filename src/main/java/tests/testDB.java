package tests;


import database.Connect_db;
import org.junit.jupiter.api.Test;

public class testDB {

    private Connect_db db_connection;

    @Test
    void test_connection() {
        db_connection = new Connect_db("admin", "S3cret");
        System.out.println(db_connection.connect());

    }

}
