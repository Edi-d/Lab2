package tests;

import java.util.Random;
import java.util.UUID;

import database.Connect_db;
import dbRepo.*;
import domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class testDB {
    private Connect_db dbConnection;

    private Repo repo;
    Random random = new Random();

    @BeforeEach
    void setUp() {
        // Initialize your database connection here if needed
        dbConnection = new Connect_db("jdbc:postgresql://localhost:5432/virtual_guide", "admin", "S3cret");
        repo = new Repo();

        Random random = new Random();
    }

    @Test
    void generalTest() throws SQLException {
        Connection db = dbConnection.connect();
        assertNotNull(db, "Connection should not be null");


        Customer customer = new Customer(0, "John", "Doe", 25, "johndoe@mail.com");
        repo.customerDatabaseRepository.addCustomer(db, customer.getId(), customer.getFirstName(), customer.getLastName(),
                customer.getAge(), customer.getEmail());

        Guide guide = new Guide(0, "John", "Doe", 25, "johndoe@mail.com");
        repo.gudiesDatabaseRepository.addGuide(db, guide.getId(), guide.getFirstName(), guide.getLastName(), guide.getAge(), guide.getEmail());

        Payment payment = new Payment(0, 1, "card");
        repo.paymentDatabaseRepository.addPayment(db, payment.getId(), payment.getPrice(), payment.getMethod());

        TourLocation location = new TourLocation(0, "Location", "Location description", "Location address");
        repo.locationDatabaseRepository.addLocation(db, location.getId(), location.getName(), location.getDescription(), location.getLocation());

        Tour tour = new Tour(0, "Tour", "Tour description", location);
        repo.tourDatabaseRepository.addTour(db, tour.getId(), tour.getName(), tour.getDescription(), tour.getLocation().getId());

        Booking booking = new Booking(0, customer, guide, tour, payment, "2021-05-05 12:00:00");
        repo.bookingDatabaseRepository.addBooking(db, booking.getId(), booking.getGuide().getId(), booking.getTour().getId(), booking.getPayment().getId(), booking.getDateTime(), booking.getCustomer().getId());

        List<Object[]> customers = repo.customerDatabaseRepository.getCustomer(db, 1);
        assertEquals(customers.size(), 0);

        customers = repo.customerDatabaseRepository.getCustomer(db, 0);
        assertEquals(customers.size(), 1);

        List<Object[]> bookings = repo.bookingDatabaseRepository.getBooking(db, 1);
        assertEquals(bookings.size(), 0);

        bookings = repo.bookingDatabaseRepository.getBooking(db, 0);
        assertEquals(bookings.size(), 1);

        repo.bookingDatabaseRepository.deleteBooking(db, 0);
        repo.customerDatabaseRepository.deleteCustomer(db, 0);
        repo.gudiesDatabaseRepository.deleteGuide(db, 0);
        repo.paymentDatabaseRepository.deletePayment(db, 0);
        repo.tourDatabaseRepository.deleteTour(db, 0);
        repo.locationDatabaseRepository.deleteLocation(db, 0);

        customers = repo.customerDatabaseRepository.getCustomer(db, 0);
        assertEquals(customers.size(), 0);

        bookings = repo.bookingDatabaseRepository.getBooking(db, 0);
        assertEquals(bookings.size(), 0);
    }

}
