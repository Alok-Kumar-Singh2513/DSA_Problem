
public class Implement_Upper_Bound {
  public static int upperBound(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;
    int answer = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] > target) {
        answer = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return answer;

  }
}
