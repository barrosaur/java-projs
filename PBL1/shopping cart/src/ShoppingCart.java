import java.util.Scanner;

public class ShoppingCart {
    public ShoppingCart() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter item name: ");
        String item_name = scanner.nextLine();

        System.out.print("Enter price: ");
        float item_price = scanner.nextFloat();

        System.out.print("Enter quantity: ");
        int item_quantity = scanner.nextInt();

        float total_price = item_price*item_quantity;

        System.out.printf("Your total: %.2f\n", total_price);
    }
}
