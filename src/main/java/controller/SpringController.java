package controller;

import authenticator.AdminUserAuthenticator;
import authenticator.Authenticator;
import authenticator.AuthenticatorProxy;
import database.Connect_db;
import dbRepo.BookingRepo;
import dbRepo.TourRepo;
import domain.Booking;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SpringController {

    Observer observer = new Observer();

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        Authenticator adminAuthenticator = new AdminUserAuthenticator();
        Authenticator authenticatorProxy = new AuthenticatorProxy(adminAuthenticator);

        if (authenticatorProxy.authenticate(email, password)) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(401).body("Login failed. Invalid credentials");
        }
    }

    @PostMapping("/add/subscriber")
    public ResponseEntity<String> addSubscriber(@RequestBody SubscribeRequest subscribeRequest) {
        String email = subscribeRequest.getEmail();

        observer.subscribe(email);

//        ArrayList<String> subscribers = observer.getSubscribers();

        return ResponseEntity.ok("Subscriber added successfully!" );
    }

    @GetMapping("/notify/subscribers")
    public ResponseEntity<String> notifySubscriber() {

        ArrayList<String> subscribers = observer.getSubscribers();

        observer.notifySubscribers();


        return ResponseEntity.ok("Subscriber notified successfully! Subscribers notified:" + subscribers);
    }


    @PostMapping("/add/tour")
    public ResponseEntity<String> addTour(@RequestBody TourRequest tourRequest) throws SQLException {
        controller.CrudRepository crudRepository = new CrudRepository();

        database.Connect_db dbConnection = new Connect_db("jdbc:postgresql://localhost:5432/virtual_guide", "admin", "S3cret");

        Connection connection = dbConnection.connect();

        TourRepo tourRepo = new TourRepo();

        tourRepo.addTour(connection, 1, tourRequest.getName(), tourRequest.getDescription(), 1);

        return ResponseEntity.ok("Tour " + tourRequest.getName() + " added successfully!");
    }

}


class TourRequest {
    private String name;
    private String description;

    public TourRequest(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }
}

class SubscribeRequest {
    private String email;

    public SubscribeRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }
}

class LoginRequest {
    private String email;
    private String password;

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
