import java.util.Scanner;

public class Tuition {
    public Tuition() {
        Scanner scanner = new Scanner(System.in);

        // Ask for first sem units
        System.out.print("1st Semester Number of units: ");
        Integer firstSemUnits = scanner.nextInt();

        // Ask for second sem units
        System.out.print("2nd Semester Number of units: ");
        Integer secondSemUnits = scanner.nextInt();

        double firstSemTuition = calculateSemFee(firstSemUnits);
        double secondSemTuition = calculateSemFee(secondSemUnits);

        System.out.printf("1st Semester tuition fee: %.2f\n", firstSemTuition);
        System.out.printf("2nd Semester tuition fee: %.2f\n", secondSemTuition);
    }

    private double calculateSemFee(int units) {
        return 450 + (450 * units) + (units * 2260) / (float) 12;
    }
}
