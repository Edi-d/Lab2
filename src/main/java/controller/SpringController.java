package controller;

import database.Connect_db;
import dbRepo.CustomerRepo;
import domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestController
@RequestMapping("/api")
public class SpringController {

//    private final AuthenticationService authenticationService;
//
//    @Autowired
//    public SpringController(AuthenticationService authenticationService) {
//        this.authenticationService = authenticationService;
//    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        // Delegate authentication logic to the service
//        boolean isAuthenticated = authenticationService.authenticate(email, password);

//        if (isAuthenticated) {
//            return "Login successful!";
//        } else {
//            return "Login failed. Invalid credentials.";
//        }

        GetUserAdapter getUserAdapter = new GetUserAdapter(new CustomerRepo());
        getUserAdapter.getUserByEmail(email);

        return "Login successful!";

    }

    // Add more request mapping methods as needed
}

class LoginRequest {
    private String email;
    private String password;

    // Getters and setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

//@Service
//class AuthenticationService {
//    private final GetUserAdapter getUserAdapter;
//
//    @Autowired
//    public AuthenticationService(GetUserAdapter getUserAdapter) {
//        this.getUserAdapter = getUserAdapter;
//    }
//
//    public boolean authenticate(String email, String password) {
//        List<Object[]> users = getUserAdapter.getUserByEmail(email);
//
//        // Your authentication logic here based on the fetched users
//
//        return !users.isEmpty();  // Placeholder logic, replace with your actual authentication logic
//    }
//}

class GetUserAdapter {
    private final CustomerRepo customerRepo;
    private final Connect_db connect_db;


    public GetUserAdapter(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
        connect_db = new Connect_db("jdbc:postgresql://localhost:5432/virtual_guide", "admin", "S3cret");
    }

    public Object getUserByEmail(String email) {
        Connection db = connect_db.connect();
        assertNotNull(db, "Connection should not be null");

        try {
            List<Object[]> returned_customers = customerRepo.getCustomerByEmail(db, email);

            if (returned_customers.isEmpty()) {
                return null;
            }

            System.out.println(returned_customers.get(0));

            Object[] returned_customer = returned_customers.get(0);
            System.out.println(returned_customer[0]);
            System.out.println(returned_customer[1]);
            System.out.println(returned_customer[2]);
            System.out.println(returned_customer[3]);
            System.out.println(returned_customer[4]);
            System.out.println(returned_customer[5]);

//            customer.setId(returned_customer.id);

            return null;
        } catch (SQLException e) {
            // Handle the exception, e.g., log it or show an error message
            e.printStackTrace();
            return Collections.emptyList(); // or another suitable action
        }
    }
}
