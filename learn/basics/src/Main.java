import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while(isRunning) {
            System.out.println("\n=== Welcome to First Sem First Year Acts ===");
            System.out.println("What would you like to do?");

            String[] menuOptions = {
                    "Salary Program",
                    "Add digits program",
                    "Quadratic Equation program",
                    "Tuition Fee computation program",
                    "Student Final Grade",
                    "Add even numbers and Product of odd numbers",
                    "Passcode program",
                    "Vowel and consonants in a string",
                    "Exit"
            };

            for(int i = 0; i < menuOptions.length; i++) {
                System.out.printf("[%d] - %s\n", i + 1, menuOptions[i]);
            }
            System.out.print("Enter choice: ");
            Integer choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Le31 salaryPrg = new Le31();
                    break;
                case 2:
                    AddDigits sum = new AddDigits();
                    break;
                case 3:
                    QuadraticEq quadEc = new QuadraticEq();
                    break;
                case 4:
                    Tuition tuition = new Tuition();
                    break;
                case 5:
                    StudFG studFG = new StudFG();
                case 6:
                    AENPON aenpon = new AENPON();
                case 7:
                    Passcode passcode = new Passcode();
                case 8:
                    VCS vcs = new VCS();
                case 9:
                    System.out.println("Exiting...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice! Choose again.\n");
            }
        }

        //scanner.close();
    }
}