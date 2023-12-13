//package authenticator;
//
//import java.util.Scanner;
//
//public class ProxyPatternLoginApp {
//    public static void main(String[] args) {
////        Authenticator adminAuthenticator = new AdminUserAuthenticator();
////        Authenticator authenticatorProxy = new AuthenticatorProxy(adminAuthenticator);
//
//        while (true) {
//            displayMenu();
//
//            Scanner scanner = new Scanner(System.in);
//            int choice = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (choice) {
//                case 1:
////                    performLogin(authenticatorProxy);
//                    break;
//                case 2:
//                    System.out.println("Exiting the application. Goodbye!");
//                    System.exit(0);
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        }
//    }
//
//    private static void displayMenu() {
//        System.out.println("Proxy Pattern Login Application");
//        System.out.println("1. Login");
//        System.out.println("2. Exit");
//        System.out.print("Enter your choice: ");
//    }
//
//    private static void performLogin(Authenticator authenticator) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter email: ");
//        String email = scanner.nextLine();
//
//        System.out.print("Enter password: ");
//        String password = scanner.nextLine();
//
//        authenticator.authenticate(email, password);
//    }
//}
