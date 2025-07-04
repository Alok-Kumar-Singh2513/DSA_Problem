// package DP;
import java.util.*;
public class o198_House_Robber {
   public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0]; // Only one house
        
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);

        int first = solve(nums, 0, n , dp1); // Rob from 0 to n-2
       
        return first;
    }

    public static int solve(int[] nums, int i, int n, int[] dp) {
        if (i > n) return 0;

        if (dp[i] != -1) return dp[i];

        int steal = nums[i] + solve(nums, i + 2, n, dp);
        int skip = solve(nums, i + 1, n, dp);

        return dp[i] = Math.max(steal, skip);
    }
}
