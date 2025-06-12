import java.util.Scanner;

public class QuadraticEq {
    public QuadraticEq() {
        Scanner scanner = new Scanner(System.in);
        double root1, root2;

        System.out.print("Enter a: ");
        Double a = scanner.nextDouble();

        System.out.print("Enter b: ");
        Double b = scanner.nextDouble();

        System.out.print("Enter c: ");
        Double c = scanner.nextDouble();

        double discriminate = calculateDiscriminate(a, b, c);

        if(a == 0 && b == 0) {
            System.out.println("There is no solution.");
        } else if (a == 0) {
            root1 = (-c)/b;
            System.out.printf("There is only one root: %.2f\n", root1);
        } else {
            if(discriminate < 0) {
                System.out.println("There are no real roots");
            } else {
                root1 = (-b - Math.sqrt(discriminate)) / (2*a);
                root2 = (-b + Math.sqrt(discriminate)) / (2*a);

                System.out.printf("The two roots are: %.2f and %.2f\n", root1, root2);
            }
        }
    }

    private double calculateDiscriminate(double a, double b, double c) {
        return (b * b) - (4 * a * c);
    }
}
