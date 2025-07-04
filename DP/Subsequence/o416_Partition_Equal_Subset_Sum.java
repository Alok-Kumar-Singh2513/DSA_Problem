package Subsequence;

public class o416_Partition_Equal_Subset_Sum {
    public static boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;
        if (total % 2 != 0) return false;
        return isSubsetSum(nums, total / 2);
    }
    public static boolean isSubsetSum(int[] arr, int sum) {
        Boolean[][] dp = new Boolean[arr.length][sum + 1];
        return help(arr.length - 1, sum, arr, dp);
    }
    public static boolean help(int index, int target, int[] arr, Boolean[][] dp) {
        if (target == 0) return true;
        if (index == 0) return arr[index] == target;

        if (dp[index][target] != null) return dp[index][target];

        boolean notTake = help(index - 1, target, arr, dp);
        boolean take = false;

        if (target >= arr[index]) {
            take = help(index - 1, target - arr[index], arr, dp);
        }

        dp[index][target] = take || notTake;

        return dp[index][target];
    }

}
