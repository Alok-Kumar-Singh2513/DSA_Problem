public class o42_Max_SubArray_Problem {
  public static int maxSubArray(int[] nums) {
    // Handle edge case when array is empty
    if (nums == null || nums.length == 0) {
        return 0;
    }
    
    // Step 1: Initialize dp array
    int[] dp = new int[nums.length];
    dp[0] = nums[0];  // First element is the initial value for dp[0]
    int maxSum = dp[0];  // Keep track of the maximum sum found

    // Step 2: Fill dp array
    for (int i = 1; i < nums.length; i++) {
        dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);  // Choose whether to add nums[i] to the previous subarray or start a new subarray
        maxSum = Math.max(maxSum, dp[i]);  // Update maxSum
    }

    // Step 3: Return the maximum subarray sum
    return maxSum;
}

public static void main(String[] args) {
    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println("Maximum Subarray Sum: " + maxSubArray(nums));
}
}
