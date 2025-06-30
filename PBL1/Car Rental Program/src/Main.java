import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Car Rental System ===");
        boolean isRunning = true;

        while(isRunning) {
            System.out.println();
            System.out.println("What would you like to do? ");
            displayMainMenu();
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Car.carMenu();
                    break;
                case 2:
                    Customer.customerMenu();
                    break;
                case 3:
                    System.out.println("Quitting program...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("[1] - Car menu");
        System.out.println("[2] - Customer menu");
        System.out.println("[3] - Exit Program");
    }
}