public class Main {
  public static void main(String[] args) {
    LinkedList list = new LinkedList();

    list.push(1);
    list.push(2);
    list.push(3);
    list.push(4);

    list.printList();

    list.remove(3);
    System.out.println();
    list.printList();

    list.push(30);
    System.out.println();
    list.printList();
  }
}