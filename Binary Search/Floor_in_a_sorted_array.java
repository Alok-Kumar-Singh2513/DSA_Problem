
public class Floor_in_a_sorted_array {
  public static int floor(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;
    int answer = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] <= target) {
        answer = mid;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return answer >= 0 ? arr[answer] : -1;

  }
}
