public class Main {
  public static void main(String[] args) {
    int[] arr = {4, 2, 1, 5, 3};
    int size = arr.length;

    BubbleSort.SortDescending(arr, size);
    System.out.println();
    BubbleSort.SortAscending(arr, size);
  }
}