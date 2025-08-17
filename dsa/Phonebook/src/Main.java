import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean isRunning = true;

    while(isRunning) {
      System.out.println("\n\n=== PHONEBOOK ===");
      displayMenu();
      System.out.print("Enter choice: ");
      int choice = scanner.nextInt();
      scanner.nextLine();

      switch(choice) {
        case 1:
          System.out.println("------ Append Record -----");
          System.out.print("Enter name: ");
          String name = scanner.nextLine();
          System.out.print("Enter number: ");
          String number = scanner.nextLine();

          if(number.length() != 6) {
            System.out.println("❌ Error: Number does not meet length requirement of 6");
            break;
          }

          if(Phonebook.AppendRecord(number, name)) {
            System.out.println("✅ Success: Record Appended!\n");
          } else {
            System.out.println("❌ Error: Record failed to append\n");
          }

          break;
        case 2:
          System.out.println("----- Edit Record -----");
          System.out.print("Enter number to edit: ");
          String numberToEdit = scanner.nextLine();

          if(Phonebook.EditRecord(numberToEdit)) {
            System.out.println("✅ Success: Record updated!");
          } else {
            System.out.println("❌ Error: Record failed to update");
          }
          break;
        case 3:
          System.out.println("----- Delete a Record -----");
          System.out.print("Enter number to delete: ");
          String numberToDel = scanner.nextLine();

          if(Phonebook.DeleteRecord(numberToDel)) {
            System.out.println("✅ Success: Record deleted!");
          } else {
            System.out.println("❌ Error: Record not deleted");
          }
          break;
        case 4:
          Phonebook.DisplayRecords();
          break;
        case 5:
          System.out.println("Exiting...");
          System.exit(0);
        default:
          System.out.println("❌ Error: Invalid Choice");
      }
    }
  }

  private static void displayMenu() {
    System.out.println("====================");
    System.out.println("[1] - Append Record");
    System.out.println("[2] - Edit Record");
    System.out.println("[3] - Delete Record");
    System.out.println("[4] - Display Record");
    System.out.println("[5] - Exit");
  }
}