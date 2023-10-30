package ui;
import controller.Controller;
import domain.Customer;

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
        System.out.println("Enter customer details:");
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        System.out.print("CustomerId: ");
        int customerId = scanner.nextInt();
        Customer newCustomer = new Customer(firstName, lastName, age, customerId);
        customerController.create(newCustomer);
        System.out.println("Customer added successfully!");
    }

    private void removeBooking() {
        System.out.print("Enter customer ID to remove: ");
        int customerId = scanner.nextInt();
        customerController.remove(customerId);
        System.out.println("Customer removed successfully!");
    }

    private void viewAllBookings() {
        Iterable<Customer> customers = customerController.getAll();
        System.out.println("List of customers:");
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }
}
