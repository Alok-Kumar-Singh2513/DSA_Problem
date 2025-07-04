package o2D_Matrix;

import java.util.Arrays;

public class o63_Unique_Paths_II {
  public static int help(int[][] obstacleGrid, int[][] dp, int n, int m) {
    
        if (n < 0 || m < 0 || obstacleGrid[n][m] == 1) return 0;
        if (n == 0 && m == 0) return 1;
        if (dp[n][m] != -1) return dp[n][m];
        int up = help(obstacleGrid, dp, n - 1, m);   // Move up
        int left = help(obstacleGrid, dp, n, m - 1); // Move left
        dp[n][m] = up + left;
        return dp[n][m]=up+left;
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        // If the starting point or the destination is an obstacle, return 0
        if (obstacleGrid[0][0] == 1 || obstacleGrid[n - 1][m - 1] == 1) return 0;
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1); 
        }
        return help(obstacleGrid, dp, n - 1, m - 1);
    }
}
