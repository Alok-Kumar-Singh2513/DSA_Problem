package Sliding_Window;

public class o1004_Max_Consecutive_Ones_III {
  public int longestOnes(int[] nums, int k) {
    int left = 0, right = 0;
    int maxLength = 0;
    int zeroCount = 0;

    while (right < nums.length) {
      if (nums[right] == 0) {
        zeroCount++;
      }

      while (zeroCount > k) {
        if (nums[left] == 0) {
          zeroCount--;
        }
        left++;
      }

      maxLength = Math.max(maxLength, right - left + 1);
      right++;
    }

    return maxLength;
  }
  public static void main(String[] args) {
    o1004_Max_Consecutive_Ones_III solution = new o1004_Max_Consecutive_Ones_III();
    int[] nums = {1, 1, 0, 0, 1, 1, 1, 0, 1};
    int k = 2;
    int result = solution.longestOnes(nums, k);
    System.out.println("The length of the longest subarray with at most " + k + " zeros is: " + result);
  }
}
