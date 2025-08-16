public class MyStack {
  static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  private Node top;
  public MyStack() {
    this.top = null;
  }

  public void push(int data) {
    Node newNode = new Node(data);
    newNode.next = top;
    top = newNode;
  }

  public int pop() {
    if(isEmpty()) {
      System.out.println("Can't pop. Stack empty or gonna be empty");
    }

    int popped = top.data;
    top = top.next;
    return popped;
  }

  public int peek() {
    if(isEmpty()) {
      System.out.println("Stack Empty");
    }

    return top.data;
  }

  public boolean isEmpty() {
    return top == null;
  }

  public void printStack() {
    Node current = top;
    while(current != null) {
      System.out.println(current.data);
      current = current.next;
    }
  }
}