public class Main {
  public static void main(String[] args) {
    int[] arr = {3, 4, 1, 5, 2};
    int size = arr.length;

    InsertionSort.SortAscending(arr, size);
    System.out.println();
    InsertionSort.SortDescending(arr, size);
  }
}