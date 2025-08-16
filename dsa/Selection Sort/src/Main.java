public class Main {
  public static void main(String[] args) {
    int[] arr = {3, 1, 5, 2, 4};
    int size = arr.length;

    SelectionSort.SortAscending(arr, size);
    System.out.println();
    SelectionSort.SortDescending(arr, size);
  }
}