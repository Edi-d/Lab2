package ui;

import controller.Controller;
import domain.Tour;

import java.util.Scanner;

public class TourUI {
    private Controller<Tour> tourController;
    private Scanner scanner;

    public TourUI(Controller<Tour> tourController) {
        this.tourController = tourController;
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
                    addTour();
                    break;
                case 2:
                    // Add option to remove a tour
                    break;
                case 3:
                    viewAllTours();
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
        System.out.println("1. Add a tour");
        System.out.println("2. Remove a tour (not implemented)");
        System.out.println("3. View all tours");
        System.out.println("0. Exit");
    }

    private void addTour() {
        System.out.println("Enter tour details:");
        System.out.print("TourId: ");
        int Id = scanner.nextInt();
        System.out.print("Tour Name: ");
        String name = scanner.nextLine();
        System.out.print("Tour Description: ");
        String description = scanner.nextLine();
        System.out.print("Tour Type: ");
        String tourtype = scanner.nextLine();
        System.out.print("Tour Price: ");
        float price = scanner.nextInt();

        Tour newTour = tourController.createTour(Id, name, description, tourtype, price);
        tourController.add(newTour);

        System.out.println("Tour added successfully!");
    }

    private void viewAllTours() {
        Iterable<Tour> tours = tourController.getAll();
        System.out.println("List of Tours:");
        for (Tour tour : tours) {
            System.out.println(tour.toString());
        }
    }
}
