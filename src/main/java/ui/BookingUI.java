package ui;
import controller.Controller;
import domain.Booking;


import java.util.Scanner;

public class BookingUI {
    private Controller bookingController;
    private Scanner scanner;

    public BookingUI(Controller customerController) {
        this.bookingController = customerController;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            printMenu();
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left by nextInt()

            switch (option) {
                case 1:
                    addBooking();
                    break;
                case 2:
                    removeBooking();
                    break;
                case 3:
                    viewAllBookings();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private void printMenu() {
        System.out.println("Select an option:");
        System.out.println("1. Add a booking");
        System.out.println("2. Remove a booking");
        System.out.println("3. View all bookings");
        System.out.println("0. Exit");
    }

    private void addBooking() {
        System.out.println("Enter booking details:");
        System.out.print("Booking ID: ");
        int bookingId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character left by nextInt()

//        this.bookingId = bookingId;
//        this.guide = guide;
//        this.tour = tour;
//        this.payment = payment;
//        this.dateTime = dateTime;

        // Create Booking object
//        Booking newBooking = new Booking(bookingId, /* guide */, /* tour */, /* payment */, /* dateTime */);

//        bookingController.add(newBooking);
        System.out.println("Booking added successfully!");
    }

    private void removeBooking() {
        System.out.print("Enter booking ID to remove: ");
        int bookingIdToRemove = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character left by nextInt()

        bookingController.remove(bookingIdToRemove);
        System.out.println("Booking removed successfully!");
    }

    private void viewAllBookings() {
        Iterable<Booking> bookings = bookingController.getAll();
        System.out.println("List of bookings:");
        for (Booking booking : bookings) {
            System.out.println(booking.toString());
        }
    }
}
