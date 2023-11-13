package tests;

import controller.Controller;
import domain.*;
import repository.BookingRepository;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    private Controller bookingController;
    private Repository<Booking> bookingRepository;

    @BeforeEach
    void setUp() {
        bookingRepository = new BookingRepository();
        bookingController = new Controller(bookingRepository);
    }

    @Test
    void saveBookingTest() {
        Guide guide = new Guide(1, "Daniel", "Petrascu", 21, "test@gmail.com");
        Tour tour = new Tour(1, "Hidden Wonders of CLuj-Napoca", "The best tour in the city");
        Payment payment =  new Payment(1, 100, "Paypal");
        Booking booking = new Booking(1, guide, tour, payment, "2023-10-01");
        bookingController.add(booking);

        List<Booking> bookings = bookingRepository.getAll();

        assertEquals(1, bookings.size());
        assertEquals(booking, bookings.get(0));
    }

    @Test
    void saveBookingsTest() {
        Guide guide = new Guide(1, "Daniel", "Petrascu", 21, "test@gmail.com");
        Tour tour = new Tour(1, "Hidden Wonders of CLuj-Napoca", "The best tour in the city");
        Payment payment =  new Payment(1, 100, "Paypal");

        Booking booking1 = new Booking(1, guide, tour, payment, "2023-10-01");
        Booking booking2 = new Booking(2, guide, tour, payment, "2023-10-02");

        bookingController.add(booking1);
        bookingController.add(booking2);

        List<Booking> bookings = bookingRepository.getAll();

        assertEquals(2, bookings.size());
        assertEquals(List.of(booking1, booking2), bookings);
    }

    @Test
    void removeBookingTest() {
        Guide guide = new Guide(1, "Daniel", "Petrascu", 21, "test@gmail.com");
        Tour tour = new Tour(1, "Hidden Wonders of CLuj-Napoca", "The best tour in the city");
        Payment payment =  new Payment(1, 100, "Paypal");

        Booking bookingToRemove = new Booking(1, guide, tour, payment, "2023-10-01");
        bookingRepository.add(bookingToRemove);

        bookingController.remove(bookingToRemove.getId());

        List<Booking> bookings = bookingRepository.getAll();

        assertEquals(0, bookings.size());
    }
}