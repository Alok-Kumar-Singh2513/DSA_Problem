// package Subset_Sum_&_01_Knapsack;
import java.util.Arrays;
public class Perfect_Sum_Problem_Count {
  static int MOD = 1000000007;

    public static int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return perfectSumHelper(n - 1, target, nums, dp);
    }

    public static int perfectSumHelper(int index, int target, int[] arr, int[][] dp) {
        if (index == 0) {
            if (target == 0 && arr[0] == 0) return 2; // Include or exclude 0
            if (target == 0 || target == arr[0]) return 1;
            return 0;
        }

        if (dp[index][target] != -1) return dp[index][target];

        int notTake = perfectSumHelper(index - 1, target, arr, dp);
        int take = 0;

        if (arr[index] <= target)
            take = perfectSumHelper(index - 1, target - arr[index], arr, dp);

        dp[index][target] = (take + notTake) % MOD;
        return dp[index][target];
    }
}
