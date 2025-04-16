public class second_largest_element_In_Array {
  public static int findSecondLargest(int n, int[] arr) {
		// Write your code here.
    int firstLargest = Integer.MIN_VALUE;
    int secondLargest = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      if (arr[i] > firstLargest) {
        secondLargest = firstLargest;
        firstLargest = arr[i];
      } else if (arr[i] > secondLargest && arr[i] != firstLargest) {
        secondLargest = arr[i];
      }
    }
    return secondLargest;
	}
  public static void main(String[] args) {
    int arr[] = { 1, 2, 3, 4, 5 };
    int n = arr.length;
    int secondLargest = findSecondLargest(n, arr);
    System.out.println("The second largest element in the array is: " + secondLargest);
  }
}
