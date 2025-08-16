public class LinkedList {
  // define Node
  // like typedef struct in C

  static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  // head reference
  private Node head;

  // push method
  public void push(int data) {
    Node newNode = new Node(data);

    // if head has nothing, make new node head
    if(head == null) {
      head = newNode;
      return;
    }

    // if there is a head
    // traverse to the end
    Node current = head;
    while(current.next != null) {
      current = current.next;
    }
    current.next = newNode;
    System.out.println("Node Added!");
  }

  public void remove(int key) {
    if(head == null) {
      System.out.println("List empty!");
      return;
    }

    // if target is head
    if(head.data == key) {
      head = head.next;
      return;
    }

    Node current = head;
    Node prev = null;

    while(current != null && current.data != key) {
      prev = current;
      current = current.next;
    }

    // val does not exist
    if(current == null) {
      System.out.println("Value does not exist");
      return;
    }

    // if found then, unlink node
    prev.next = current.next;
  }

  public void printList() {
    if(head == null) {
      System.out.println("List empty!");
      return;
    }

    Node temp = head;
    while(temp != null) {
      if(temp.next != null) {
        System.out.printf("%d -> ", temp.data);
      } else {
        System.out.printf("%d ", temp.data);
      }

      temp = temp.next;
    }

    return;
  }
}