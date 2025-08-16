public class Main {
  public static void main(String[] args) {
    MyStack stack = new MyStack();

    stack.push(1);
    stack.push(2);
    stack.push(3);

    stack.printStack();
    System.out.println();

    System.out.println("Popped data: " + stack.pop());
    stack.printStack();
  }
}