public class Main {
  public static void main(String[] args) {
    Queue q = new Queue();

    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(3);
    q.enqueue(4);

    q.printQueue();
    System.out.println();

    System.out.println("Dequeued Data: " + q.dequeue());
    q.printQueue();
  }
}