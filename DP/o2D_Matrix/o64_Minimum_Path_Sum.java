package o2D_Matrix;

public class o64_Minimum_Path_Sum {
  public static int minPathSum(int[][] grid) {
       int n = grid.length;
       int m = grid[0].length;
       int[][] dp = new int[n][m];
       for (int[] row : dp) {
           java.util.Arrays.fill(row, -1); 
       }
       return minPathSumUtil(grid, 0, 0, dp, n, m);
   }

   private static int minPathSumUtil(int[][] grid, int i, int j, int[][] dp, int n, int m) {
       if (i == n - 1 && j == m - 1) {
           return grid[i][j];
       }

       if (dp[i][j] != -1) {
           return dp[i][j];
       }

       if (i == n - 1) { // Last row: move right
           dp[i][j] = grid[i][j] + minPathSumUtil(grid, i, j + 1, dp, n, m);
       } else if (j == m - 1) { // Last column: move down
           dp[i][j] = grid[i][j] + minPathSumUtil(grid, i + 1, j, dp, n, m);
       } else {
           int down = minPathSumUtil(grid, i + 1, j, dp, n, m);
           int right = minPathSumUtil(grid, i, j + 1, dp, n, m);
           dp[i][j] = grid[i][j] + Math.min(down, right);
       }

       return dp[i][j];
   }
  }
