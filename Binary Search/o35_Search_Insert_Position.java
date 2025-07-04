// Description: 35. Search Insert Position
// Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

public class o35_Search_Insert_Position {
  public static int searchInsert(int[] arr, int target) {
    int n = arr.length;
    int low = 0, high = n - 1;
    int ans = n;

    while (low <= high) {
      int mid = (low + high) / 2;
      // maybe an answer
      if (arr[mid] >= target) {
        ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return ans;

  }

  public static void main(String[] args) {
    int[] arr = { 1, 3, 5, 6 };
    int target = 5;
    int result = searchInsert(arr, target);
    System.out.println("The index of the target " + target + " is: " + result);
    // Output: 2

  }
}
