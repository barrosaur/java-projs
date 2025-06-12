import java.util.Scanner;

public class AddDigits {
    public AddDigits() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number: ");
        Integer num = scanner.nextInt();

        int lastDigit = extractLastDigit(num);
        int secondLD = extractSecondLastDigit(num);
        int sumDigits = sumDigits(secondLD, lastDigit);

        System.out.printf("%d + %d = %d\n", lastDigit, secondLD, sumDigits);
    }

    private int extractLastDigit(int num) {
        int lastDigit;
        lastDigit = num % 10;

        return lastDigit;
    }

    private int extractSecondLastDigit(int num) {
        int secondLD;
        secondLD = ((num % 100) - (num % 10)) / 10;

        return secondLD;
    }

    private int sumDigits(int num1, int num2) {
        return num1 + num2;
    }
}
