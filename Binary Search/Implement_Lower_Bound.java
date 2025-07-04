
public class Implement_Lower_Bound {
  public static int lowerBound(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;
    int answer = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] >= target) {
        answer = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    // The number id greater than or equal to the target
    // >= target
    int[] arr = { 1, 2, 4, 4, 5, 6 };
    int target = 4;
    int result = lowerBound(arr, target);
    System.out.println("The lower bound index of " + target + " is: " + result);
    // Output: 2
  }
}
