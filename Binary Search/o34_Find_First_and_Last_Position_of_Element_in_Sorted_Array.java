// Description: This code finds the first and last position of a target element in a sorted array using binary search.
// LeetCode Problem: 34. Find First and Last Position of Element in Sorted Array
// LeetCode Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// Time Complexity: O(log n)
public class o34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {

  public static int[] searchRange(int[] nums, int target) {
    int lower = lowerBound(nums, target);
    int upper = upperBound(nums, target);

    if (lower == nums.length || nums[lower] != target) {
      return new int[] { -1, -1 };
    }
    return new int[] { lower, upper - 1 };
  }

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

  public static void main(String[] args) {
    int[] nums = { 5, 7, 7, 8, 8, 10 };
    int target = 8;
    int[] result = searchRange(nums, target);
    System.out.println("First and Last Position: [" + result[0] + ", " + result[1] + "]");
  }
}
