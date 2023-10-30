package ui;

import controller.CustomerController;
import domain.Customer;

import java.util.Scanner;

public class CustomerUI {
    private CustomerController customerController;

    public CustomerUI(CustomerController customerController) {
        this.customerController = customerController;
    }

    public void run() {
        int option;
        boolean exit = true;
        Scanner scanner = new Scanner(System.in);
        while (exit) {
            System.out.println("Select an option:");
            System.out.println("1. Add a customer");
            System.out.println("2. Remove a customer");
            System.out.println("3. View all customers");
            System.out.println("0. Exit");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left by nextInt()

            switch (option) {
                case 1:
                    System.out.println("Enter customer details:");
                    System.out.print("First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Age: ");
                    int age = scanner.nextInt();
                    System.out.print("CustomerId: ");
                    int customerid = scanner.nextInt();
                    Customer newCustomer = new Customer(firstName, lastName, age, customerid);
                    customerController.createCustomer(newCustomer);
                    System.out.println("Customer added successfully!");
                    break;
                case 2:
                    System.out.print("Enter customer ID to remove: ");
                    int customerId = scanner.nextInt();
                    customerController.removeCustomer(customerId);
                    System.out.println("Customer removed successfully!");
                    break;
                case 3:
                    Iterable<Customer> customers = customerController.getAllCustomers();
                    System.out.println("List of customers:");
                    for (Customer customer : customers) {
                        System.out.println(customer.toString());
                    }
                    break;
                case 0:
                    exit = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}
