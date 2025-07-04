

public class o2328_Number_of_Increasing_Paths_in_a_Grid {
   public static int[][] dp;
    public static int mod = 1000000007;
   public static int countPaths(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
       dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i][j] = -1;
            }
        }
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                count = (count + dfs(grid, i, j)) % mod;
            }
        }
        return count;
    }
    public static int dfs(int grid[][], int i, int j) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int count = 1; 
        int rows = grid.length;
        int cols = grid[0].length;
        // Check all 4 directions
        int[] rowDir = {-1, 1, 0, 0};
        int[] colDir = {0, 0, -1, 1};
        for (int d = 0; d < 4; d++) {
            int newRow = i + rowDir[d];
            int newCol = j + colDir[d];
            if (isValid(newRow, newCol, rows, cols) && grid[newRow][newCol] > grid[i][j]) {
                count = (count + dfs(grid, newRow, newCol)) % mod;
            }
        }
        return dp[i][j] = count;
    }
    public static boolean isValid(int i, int j, int rows, int cols) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }
}
