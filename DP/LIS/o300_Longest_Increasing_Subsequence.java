package LIS;

import java.util.Arrays;

public class o300_Longest_Increasing_Subsequence {
    static int LIS(int arr[], int n, int ind, int prev_index, int[][] dp) {
        if (ind == n) return 0;

        if (dp[ind][prev_index + 1] != -1) {
            return dp[ind][prev_index + 1];
        }

        int notTake = LIS(arr, n, ind + 1, prev_index, dp);

        int take = 0;
        if (prev_index == -1 || arr[ind] > arr[prev_index]) {
            take = 1 + LIS(arr, n, ind + 1, ind, dp);
        }

        // Store result at shifted index
        dp[ind][prev_index + 1] = Math.max(take, notTake);
        return dp[ind][prev_index + 1];
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return LIS(nums, n, 0, -1, dp);
    }

    public static void main(String[] args) {
        o300_Longest_Increasing_Subsequence obj = new o300_Longest_Increasing_Subsequence();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Length of LIS: " + obj.lengthOfLIS(nums));  // Output: 4
    }
    
}
