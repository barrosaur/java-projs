import java.util.Scanner;

public class GradeAve {
    public GradeAve() {
        Scanner scanner = new Scanner(System.in);
        int subjQuan;
        double[] grades;

        System.out.print("Enter quantity of subjects taken this year: ");
        subjQuan = scanner.nextInt();
        scanner.nextLine();

        grades = new double[subjQuan];

        for(int i = 0; i < subjQuan; i++) {
            System.out.printf("Enter grade for subject %d: ", i+1);
            grades[i] = scanner.nextDouble();
        }

        System.out.printf("Your GPA is %.2f\n", CalculateAve(grades));

        scanner.close();
    }

    private static double CalculateAve(double...grades) {
        double sum = 0;

        for(double grade : grades) {
            sum += grade;
        }

        return sum / grades.length;
    }
}
