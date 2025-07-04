// package Subset_Sum_&_01_Knapsack;

public class o416_Partition_Equal_Subset_Sum {
   public static boolean help(int index, int[] nums, int target, Boolean[][] dp) {
      
        if (target == 0) return true; // If target is 0, the subset exists (empty subset)
        if (index == 0) return nums[index] == target; // If we're at the first element, check if it equals the target

        // If already calculated, return the stored value
        if (dp[index][target] != null) return dp[index][target];

        // Recursive calls: decide whether to include or exclude the current element
        boolean notTake = help(index - 1, nums, target, dp); // Exclude current element
        boolean take = false;
        if (target >= nums[index]) { // Include current element if target is large enough
            take = help(index - 1, nums, target - nums[index], dp);
        }

   
        dp[index][target] = take || notTake;

        return dp[index][target];
    }

    // Main function to check if partition is possible
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) return false;

        int target = totalSum / 2; 
        int n = nums.length;
        Boolean[][] dp = new Boolean[n][target + 1]; 
        return help(n - 1, nums, target, dp); 
    }
}
