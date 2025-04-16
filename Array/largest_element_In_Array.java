public class largest_element_In_Array {
  public static int largestElement(int[] arr, int n) {

    int max = arr[0];
    for (int i = 1; i < n; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;

  }

  // Second Method
  public static int largestElement2(int[] arr, int n) {
    int max = arr[0];
    for (int i = 1; i < n; i++) {
      max = Math.max(max, arr[i]);
    }
    return max;
  }

  public static void main(String[] args) {
    int arr[] = { 1, 2, 3, 4, 5 };
    int n = arr.length;
    int largest = largestElement(arr, n);
    System.out.println("The largest element in the array is: " + largest);
  }

}
