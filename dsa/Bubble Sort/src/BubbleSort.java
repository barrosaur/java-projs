public class BubbleSort {
  int[] arr;
  int size;

  BubbleSort(int[] arr, int size) {
    this.arr = arr;
    this.size = size;
  }

  public static void SortAscending(int[] arr, int size) {
    for(int i = 0; i < size; i++) {
      for(int j = 0; j < size - 1; j++) {
        if(arr[j] > arr[j+1]) {
          int temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
        }
      }
    }

    for(int num : arr) {
      System.out.print(num + " ");
    }
  }

  public static void SortDescending(int[] arr, int size) {
    for(int i = 0; i < size; i++) {
      for(int j = 0; j < size - 1; j++) {
        if (arr[j] < arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }

    for(int num : arr) {
      System.out.print(num + " ");
    }
  }
}
