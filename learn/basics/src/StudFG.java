import java.util.Scanner;

public class StudFG {

    public StudFG() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter mark 1: ");
        double mark1 = scanner.nextDouble();
        System.out.print("Enter mark 2: ");
        double mark2 = scanner.nextDouble();
        System.out.print("Enter mark 3: ");
        double mark3 = scanner.nextDouble();
        System.out.print("Enter mark 4: ");
        double mark4 = scanner.nextDouble();

        boolean condition = ((mark1 < 0 && mark1 > 100) && (mark2 < 0 && mark2 > 100) && (mark3 < 0 && mark3 > 100) && (mark4 < 0 && mark4 > 100));

        if(condition) {
            double finalGrade = computeFinalGrade(mark1, mark2, mark3, mark4);
            System.out.printf("Final Grade: %.2f\n");
        } else {
            System.out.println("INVALID INPUT!");
        }
    }

    private double computeFinalGrade(double mark1, double mark2, double mark3, double mark4) {
        return (mark1 + mark2 + mark3 + mark4) / 4;
    }
}
