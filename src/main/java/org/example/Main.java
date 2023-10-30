package org.example;
import controller.Controller;
import domain.Customer;
import repository.BookingRepository;
import repository.CustomerRepository;
import ui.CustomerUI;
import ui.UI;

public class Main {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepository();
        Controller customerController = new Controller(customerRepository);

        BookingRepository bookingRepository = new BookingRepository();
        Controller bookingController =  new Controller(bookingRepository);

        UI ui = new UI(customerController, bookingController);
        ui.start();

    }
}