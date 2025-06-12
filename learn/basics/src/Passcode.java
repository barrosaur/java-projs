import java.util.Scanner;

public class Passcode {
    public Passcode() {
        Scanner scanner = new Scanner(System.in);

        int attempts = 0;
        int passcode = 1234;

        while(attempts != 3) {
            System.out.println("Enter passcode: ");
            int enteredPasscode = scanner.nextInt();

            if(enteredPasscode == passcode) {
                System.out.println("ACCESS GRANTED!");
                break;
            } else {
                attempts++;

                if(attempts == 3) {
                    System.out.println("ACCESS DENIED!");
                    break;
                } else {
                    System.out.println("Try again.");
                }
            }
        }
    }
}
