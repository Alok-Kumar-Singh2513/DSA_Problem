// package DP;

import java.util.Arrays;

public class o213_House_Robber {
   public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0]; // Only one house
        
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);

        int first = solve(nums, 0, n - 2, dp1); // Rob from 0 to n-2
        int second = solve(nums, 1, n - 1, dp2); // Rob from 1 to n-1
        return Math.max(first, second);
    }

    public static int solve(int[] nums, int i, int n, int[] dp) {
        if (i > n) return 0;

        if (dp[i] != -1) return dp[i];

        int steal = nums[i] + solve(nums, i + 2, n, dp);
        int skip = solve(nums, i + 1, n, dp);

        return dp[i] = Math.max(steal, skip);
    }
    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
        System.out.println("Maximum amount robbed: " + rob(nums)); // Output: 3
        
    }
}
