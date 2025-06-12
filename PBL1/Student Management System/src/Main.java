import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int password = 12345;
        int enteredPass, attempts = 0;

        System.out.println("Welcome to admin portal!");

        // check password
        while(attempts != 3) {
            System.out.print("Enter password: ");
            enteredPass = scanner.nextInt();

            if(enteredPass == password) {
                System.out.println("ACCESS GRANTED!");
                startPrg();
                break;
            } else {
                attempts++;

                if(attempts < 3) {
                    System.out.println("Try again");
                } else {
                    System.out.println("ACCESS DENIED!");
                    break;
                }
            }
        }
    }

    private static void startPrg() {
        boolean isRunning = true;

        while(isRunning) {
            System.out.println("\nWhat would you like to do? ");
            System.out.println("[1] - Add a new student.");
            System.out.println("[2] - Update student information.");
            System.out.println("[3] - Delete student info.");
            System.out.println("[4] - Search");
            System.out.println("[5] - Show Student Information");
            System.out.println("[6] - Exit Program");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    StudentManager.addStudent();
                    break;
                case 2:
                    StudentManager.updateStudent();
                    break;
                case 3:
                    StudentManager.deleteStudent();
                    break;
                case 4:
                    Student studStatus = StudentManager.searchStudent();

                    if(studStatus != null) {
                        System.out.println("Student FOUND!");
                    } else {
                        System.out.println("Student NOT FOUND!");
                    }

                    break;
                case 5:
                    StudentManager.showStudInfo();
                    break;
                case 6:
                    System.out.println("Quitting program...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }
}