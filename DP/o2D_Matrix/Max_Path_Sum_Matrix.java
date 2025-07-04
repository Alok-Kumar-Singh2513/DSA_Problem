package o2D_Matrix;

public class Max_Path_Sum_Matrix {
   public static int maxPathSum(int[][] grid) {
       int n = grid.length;
       int m = grid[0].length;
       int[][] dp = new int[n][m];
       for (int[] row : dp) {
           java.util.Arrays.fill(row, -1); 
       }
       return maxPathSumUtil(grid, 0, 0, dp, n, m);
   }
    private static int maxPathSumUtil(int[][] grid, int i, int j, int[][] dp, int n, int m) {
        if (i == n - 1 && j == m - 1) {
            return grid[i][j];
        }
  
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
  
        if (i == n - 1) { // Last row: move right
            dp[i][j] = grid[i][j] + maxPathSumUtil(grid, i, j + 1, dp, n, m);
        } else if (j == m - 1) { // Last column: move down
            dp[i][j] = grid[i][j] + maxPathSumUtil(grid, i + 1, j, dp, n, m);
        } else {
            int down = maxPathSumUtil(grid, i + 1, j, dp, n, m);
            int right = maxPathSumUtil(grid, i, j + 1, dp, n, m);
            dp[i][j] = grid[i][j] + Math.max(down, right);
        }
  
        return dp[i][j];
    }
}
