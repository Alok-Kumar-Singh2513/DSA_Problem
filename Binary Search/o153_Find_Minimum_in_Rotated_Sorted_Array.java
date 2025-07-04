// Description: This code finds the minimum element in a rotated sorted array using binary search.
// LeetCode Problem: 153. Find Minimum in Rotated Sorted Array
// LeetCode Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
// Time Complexity: O(log n)

public class o153_Find_Minimum_in_Rotated_Sorted_Array {
  public static int findMin(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    int answer = Integer.MAX_VALUE;
    while(left<right){
      int mid = left + (right - left) / 2;
      if(nums[left] <= nums[mid]){
        answer = Math.min(answer, nums[left]);
        left = mid + 1; // Move to the right half
      }else{
        answer = Math.min(answer, nums[mid]);
        right = mid-1; // Move to the left half
      }

    }
    return Math.min(answer, nums[left]); 
  }
  public static void main(String[] args) {
    int[] nums = { 3, 4, 5, 1, 2 };
    int result = findMin(nums);
    System.out.println("The minimum element in the rotated sorted array is: " + result);
    // Output: 1
  }
}
