package tests;

import controller.Controller;
import domain.Booking;
import org.junit.jupiter.api.BeforeEach;
import repository.BookingRepository;
import repository.Repository;

public class Tests2 {

    private Controller customerController;
    private Repository<Booking> bookingRepository;

    @BeforeEach
    void setUp() {
        bookingRepository = new BookingRepository();
        customerController = new Controller(bookingRepository);
    }



}
