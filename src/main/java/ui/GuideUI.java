package ui;
import controller.Controller;
import domain.Guide;
import domain.Subscriber;

import java.util.Scanner;

public class GuideUI {
    private Controller guideController;
    private Controller subscriberController;
    private Scanner scanner;

    public GuideUI(Controller guideController) {
        this.guideController = guideController;
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
                    addGuide();
                    break;
                case 2:
                    removeGuide();
                    break;
                case 3:
                    viewAllGuides();
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
        System.out.println("1. Add a guide");
        System.out.println("2. Remove a guide");
        System.out.println("3. View all guides");
        System.out.println("0. Exit");
    }

    private void addGuide() {
        System.out.println("Enter guide details:");
        System.out.print("GuideId: ");
        int Id = scanner.nextInt();
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        Guide newGuide = new Guide(Id, firstName, lastName, age, email, password);
        guideController.add(newGuide);

        Subscriber subscriber = Subscriber.getInstance(Id, firstName, email);
        subscriberController.add(subscriber);
        subscriberController.notify();

        System.out.println("Guide added successfully!");
    }

    private void removeGuide() {
        System.out.print("Enter Guide ID to remove: ");
        int GuideId = scanner.nextInt();
        guideController.remove(GuideId);
        System.out.println("Guide removed successfully!");
    }

    private void viewAllGuides() {
        Iterable<Guide> Guides = guideController.getAll();
        System.out.println("List of Guides:");
        for (Guide Guide : Guides) {
            System.out.println(Guide.toString());
        }
    }
}
