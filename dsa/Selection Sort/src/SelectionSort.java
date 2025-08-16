public class SelectionSort {
  int[] arr;
  int size;

  SelectionSort(int[] arr, int size) {
    this.arr = arr;
    this.size = size;
  }

  public static void SortAscending(int[] arr, int size) {
    for(int i = 0; i < size - 1; i++) {
      int min = i;

      for(int j = i + 1; j < size; j++) {
        if(arr[j] < arr[min]) {
          min = j;
        }
      }

      int temp = arr[i];
      arr[i] = arr[min];
      arr[min] = temp;
    }

    for(int num: arr) {
      System.out.print(num + " ");
    }
  }

  public static void SortDescending(int[] arr, int size) {
    for(int i = 0; i < size - 1; i++) {
      int min = i;

      for(int j = i + 1; j < size; j++) {
        if(arr[j] > arr[min]) {
          min = j;
        }
      }

      int temp = arr[i];
      arr[i] = arr[min];
      arr[min] = temp;
    }

    for(int num : arr) {
      System.out.print(num + " ");
    }
  }
}
