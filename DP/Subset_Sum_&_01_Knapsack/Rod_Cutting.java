// package Subset_Sum_&_01_Knapsack;

import java.util.Arrays;

public class Rod_Cutting {
  public static int cutRod(int[] price) {
        // code here
        int n = price.length;
        int[][]dp = new int[n + 1][n + 1];
        for(int[] row: dp) Arrays.fill(row, -1);
        return cutRodUtil(price, 0, dp, n);
    }

    static int cutRodUtil(int[] price, int index, int[][] dp) {
        if (index == 0) return 0;
        if (dp[index][N] != -1) return dp[index][index];

        int take = Integer.MIN_VALUE;
        int rolength = index + 1; // The length of the rod we can cut
        int notTake = 0 + cutRodUtil(price, index - 1, dp);
        if (rolength < N) {
            take = price[index] + cutRodUtil(price, index - rolength, dp);
        }
        return dp[index][N] = Math.max(take, notTake);

    }
}
