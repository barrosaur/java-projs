public class Queue {
  static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  private Node front, rear;

  public Queue() {
    this.front = this.rear = null;
  }

  public void enqueue(int data) {
    Node newNode = new Node(data);

    // if empty, front rear same
    if(rear == null) {
      front = rear = newNode;
      return;
    }

    rear.next = newNode;
    rear = newNode;
  }

  public int dequeue() {
    if(isEmpty()) {
      System.out.println("Queue empty");
    }

    int removed = front.data;
    front = front.next;

    // when removing front and queue becomes empty
    if(front == null) {
      rear = null;
    }

    return removed;
  }

  public int peek() {
    if(isEmpty()) {
      System.out.println("Queue empty");
    }

    return front.data;
  }

  public boolean isEmpty() {
    return front == null;
  }

  public void printQueue() {
    if(isEmpty()) {
      System.out.println("Queue empty");
    }

    Node current = front;
    while(current != null) {
      if(current.next != null) {
        System.out.printf("%d <- ", current.data);
      } else {
        System.out.printf("%d ", current.data);
      }
      current = current.next;
    }
  }
}
