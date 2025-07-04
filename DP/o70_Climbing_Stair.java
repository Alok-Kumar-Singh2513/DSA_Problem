// package DP;

import java.util.Arrays;

public class o70_Climbing_Stair {
  public static int[] dp;

    public static int help(int n, int[] dp) {
        if (n == 0 || n == 1) return 1;
        if (dp[n] != -1) return dp[n];
        dp[n] = help(n - 1, dp) + help(n - 2, dp);
        return dp[n];
    }

    public int climbStairs(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return help(n, dp);
    }

    // By tabulation
    // Time complexity: O(n)
    // Space complexity: O(n)
    public int climbStairsTab(int n) {
        if (n == 0 || n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // By space optimization
    // Time complexity: O(n)
    // Space complexity: O(1)
    public int climbStairsSpaceOpt(int n) {
        if (n == 0 || n == 1) return 1;
        int prev1 = 1, prev2 = 1, curr = 0;
        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
    public static void main(String[] args) {
        o70_Climbing_Stair obj = new o70_Climbing_Stair();
        int n = 5; 
        System.out.println("Number of ways to climb " + n + " stairs: " + obj.climbStairs(n));
    }
}
