// package Binary Search;

public class How_many_Times_Has_An_Array_Been_Rotated {
  public static int findKRotation(int[] arr) {
  int low = 0, high = arr.length - 1;
  int ans = Integer.MAX_VALUE;
  int index = -1;
  while (low <= high) {
      int mid = (low + high) / 2;
     
      if (arr[low] <= arr[high]) {
          if (arr[low] < ans) {
              index = low;
              ans = arr[low];
          }
          break;
      }

      //if left part is sorted:
      if (arr[low] <= arr[mid]) {
          // keep the minimum:
          if (arr[low] < ans) {
              index = low;
              ans = arr[low];
          }

          // Eliminate left half:
          low = mid + 1;
      } else { //if right part is sorted:

          // keep the minimum:
          if (arr[mid] < ans) {
              index = mid;
              ans = arr[mid];
          }

          // Eliminate right half:
          high = mid - 1;
      }
  }
  return index;
}
  public static void main(String[] args) {
    int[] arr = {4, 5, 6, 7, 0, 1, 2};
    int rotations = findKRotation(arr);
    System.out.println("The array has been rotated " + rotations + " times.");
    // Output: The array has been rotated 4 times.
  }
}
