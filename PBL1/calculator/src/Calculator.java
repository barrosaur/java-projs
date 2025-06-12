import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Calculator {
    public Calculator() {
        Scanner scanner = new Scanner(System.in);

        // Array of digits
        List<Integer> digits = new ArrayList<>();
        char op = ' ';

        // Get input
        System.out.print("Enter expression: ");
        String expression = scanner.nextLine();

        // Iterate through every char of input
        for(int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if(Character.isDigit(ch)) {
                int digit = Character.getNumericValue(ch);
                digits.add(digit);
            } else {
                // Add here only a valid operation character
                for(char c: expression.toCharArray()) {
                    if(c == '+' || c == '-' || c == '*' || c == '/') {
                        op = c;
                    }
                }
            }
        }

        // do calculations
        calculate(digits.get(0), digits.get(1), op);
    }

    private void calculate(Integer x, Integer y, char op) {
        int result = 0;

        switch(op) {
            case '+':
                result = x + y;
                break;
            case '-':
                result = x - y;
                break;
            case '*':
                result = x * y;
                break;
            case '/':
                if(y == 0) {
                    System.out.println("Can't divide by 0");
                    return;
                } else {
                    result = x / y;
                    break;
                }
            default:
                System.out.println("Invalid input");
        }

        System.out.println(result);
    }
}
