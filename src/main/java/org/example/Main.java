package org.example;
import controller.Controller;
import controller.CustomerController;
import domain.Customer;
import repository.CustomerRepository;
import ui.CustomerUI;
public class Main {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepository();
        Controller customerController = new Controller(customerRepository);
        CustomerUI ui = new CustomerUI(customerController);
        ui.run();

    }
}