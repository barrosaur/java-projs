public class InsertionSort {
  int[] arr;
  int size;

  InsertionSort(int[] arr, int size) {
    this.arr = arr;
    this.size = size;
  }

  public static void SortAscending(int[] arr, int size) {
    for(int i = 1; i < size; i++) {
      int key = arr[i];
      int j = i - 1;

      while(j >= 0 && arr[j] > key) {
        arr[j+1] = arr[j];
        j--;
      }

      arr[j+1] = key;
    }

    for(int num : arr) {
      System.out.print(num + " ");
    }
  }

  public static void SortDescending(int[] arr, int size) {
    for(int i = 0; i < size; i++) {
      int key = arr[i];
      int j = i - 1;

      while(j >= 0 && arr[j] < key) {
        arr[j+1] = arr[j];
        j--;
      }

      arr[j+1] = key;
    }

    for(int num : arr) {
      System.out.print(num + " ");
    }
  }
}
