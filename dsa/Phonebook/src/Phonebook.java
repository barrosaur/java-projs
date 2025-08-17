import java.util.Scanner;

public class Phonebook {
  static class Node {
    String number;
    String name;
    Node next;

    Node(String number, String name) {
      this.number = number;
      this.name = name;
      this.next = null;
    }
  }

  private static Node head = null;

  public static boolean AppendRecord(String number, String name) {
    System.out.println("\nAppending records...\n");
    Node newNode = new Node(number, name);

    // if list is empty, make the first one added as the head
    if(head == null) {
      head = newNode;
      return true;
    }

    // if list not empty, then add to the last
    Node temp = head;
    if(temp.next != null) {
      temp = temp.next;
    }
    temp.next = newNode;
    return true;
  }

  public static void DisplayRecords() {
    if(head == null) {
      System.out.println("Nothing to display...\n");
      return;
    }

    Node temp = head;
    System.out.println("\n--------- Records ---------");
    while(temp != null) {
      System.out.printf("%s\t\t\t%s\n", temp.name, temp.number);
      temp = temp.next;
    }
  }

  public static boolean EditRecord(String number) {
    Node recordFound = SearchNumber(number);
    if(recordFound == null) {
      System.out.println("❌ Error: Record not found");
      return false;
    } else {
      System.out.println("✅ Success: Record found!");
    }

    Scanner scanner = new Scanner(System.in);

    boolean isRunning = true;

    while(isRunning) {
      System.out.println("Which would you like to edit?");
      System.out.println("[1] - Name");
      System.out.println("[2] - Number");
      System.out.print("Enter choice: ");
      int choice = scanner.nextInt();
      scanner.nextLine();

      switch(choice) {
        case 1:
          System.out.print("Enter new name: ");
          String newName = scanner.nextLine();

          recordFound.name = newName;
          return true;
        case 2:
          System.out.print("Enter new number: ");
          String newNumber = scanner.nextLine();

          recordFound.number = newNumber;
          return true;
        default:
          System.out.println("❌ Error: Invalid Choice");
      }
    }

    return false;
  }

  public static boolean DeleteRecord(String number) {
    if(head == null) {
      return false;
    }

    Node recordFound = SearchNumber(number);
    if(recordFound == null) {
      System.out.println("❌ Error: Record not found");
      return false;
    }
    System.out.println("✅ Error: Record found!");
    System.out.printf("Name: %s\nNumber: %s\n", recordFound.name, recordFound.number);

    if(recordFound == head) {
      head = head.next;
      return true;
    }

    Node prev = head;
    while(prev.next != null && prev.next != recordFound) {
      prev = prev.next;
    }

    if(prev.next == recordFound) {
      prev.next = recordFound.next;
      return true;
    }

    return false;
  }

  private static Node SearchNumber(String number) {
    if(head == null) {
      return null;
    }

    if(head.number.equals(number)) {
      return head;
    }

    Node temp = head;
    while(temp != null) {
      if(temp.number.equals(number)) {
        return temp;
      }

      temp = temp.next;
    }

    return null;
  }
}
