import java.util.Scanner;

public class Le31 {
    public Le31() { //constructor
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter yearly salary: ");
        Integer salary = scanner.nextInt();

        float weeklyPay = (float) salary / 52;
        System.out.printf("Your weekly salary is: %.2f\n", weeklyPay);

        String[] status = {"Below Average", "Average", "You doin foin"};

        if(weeklyPay <= 10000) {
            System.out.printf("%s\n", status[0]);
        } else if (weeklyPay > 10000 && weeklyPay <= 50000) {
            System.out.printf("%s\n", status[1]);
        } else {
            System.out.printf("%s\n", status[2]);
        }

    }
}
