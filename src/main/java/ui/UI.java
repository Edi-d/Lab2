package ui;
import controller.Controller;
import java.util.Scanner;

public class UI {
    private Controller customerController;
    private Controller guideController;
    private Scanner scanner = new Scanner(System.in);

    public UI(Controller customerController, Controller guideController) {
        this.customerController = customerController;
        this.guideController = guideController;
    }

    public void start() {
        boolean exit = false;

        while (!exit) {
            System.out.println("Select an entity to work on:");
            System.out.println("1. Customer");
            System.out.println("2. Bookings");
            System.out.println("3. Exit");

            int entityChoice = scanner.nextInt();
            scanner.nextLine();

            switch (entityChoice) {
                case 1:
                    CustomerUI customerUI = new CustomerUI(customerController);
                    customerUI.run();
                    break;
                case 2:
                    GuideUI guideUI = new GuideUI(guideController);
                    guideUI.run();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        System.out.println("Exiting the program.");
        scanner.close();
    }
}