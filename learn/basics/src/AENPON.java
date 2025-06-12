import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class AENPON {
    private Scanner scanner;

    public AENPON() {
        scanner = new Scanner(System.in);
        int[] nums = getInput();
        int evenCount = 0, oddCount = 0;

        List<Integer> evenNums = new ArrayList<>();
        List<Integer> oddNums = new ArrayList<>();

        for(int num: nums) {
            // if even
            if(num % 2 == 0) {
                evenCount++;
                evenNums.add(num);
            } else {
                oddNums.add(num);
            }
        }

        System.out.println();

        funcEven(evenNums, evenCount);
        funcOdd(oddNums);

    }

    private int[] getInput() {
        System.out.print("How many number inputs would you like? ");
        int numInputs = scanner.nextInt();

        int[] nums = new int[numInputs];

        for(int i = 0; i < numInputs; i++) {
            System.out.printf("Enter number %d: ", i+1);
            nums[i] = scanner.nextInt();
        }

        return nums;
    }

    private void funcEven(List<Integer> evenNums, int evenCount) {
        int sum = 0;
        float average;

        System.out.println("===========================================");

        System.out.print("Even numbers from input: ");
        for(int num: evenNums) {
            System.out.printf("%d ", num);

            sum += num;
        }
        average = sum / evenCount;
        System.out.println();
        System.out.printf("Average: %.2f\n", average);

        System.out.println("===========================================");
    }

    private void funcOdd(List<Integer> oddNums) {
        int product = 1;

        System.out.print("Odd numbers from input: ");
        for(int num: oddNums) {
            System.out.printf("%d ", num);

            product *= num;
        }
        System.out.println();
        System.out.printf("Product of odd numbers: %d", product);
        System.out.println();

        System.out.println("===========================================");

    }
}
