import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("This is a simple calculator app.");
        System.out.println("INSTRUCTIONS: Write full expressions.");
        boolean isRunning = true;

        while(isRunning) {
            System.out.println("\n1. Use Calculator\n2. Exit");
            System.out.print("Enter choice: ");
            Integer choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Calculator calculator = new Calculator();
                    break;
                case 2:
                    System.out.println("Exiting...");
                    isRunning = false;
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Try again.\n");
            }
        }
    }
}