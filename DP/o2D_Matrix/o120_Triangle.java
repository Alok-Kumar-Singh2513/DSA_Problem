package o2D_Matrix;

import java.util.Arrays;
import java.util.List;

public class o120_Triangle {
   public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return minimumPathSumUtil(0, 0, triangle, n, dp);
    }
    private static int minimumPathSumUtil(int i, int j, List<List<Integer>> triangle, int n, int[][] dp) {
        if (i == n - 1) {
            return triangle.get(i).get(j);
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int down = minimumPathSumUtil(i + 1, j, triangle, n, dp);
        int diagonal = minimumPathSumUtil(i + 1, j + 1, triangle, n, dp);

        dp[i][j] = triangle.get(i).get(j) + Math.min(down, diagonal);
        return dp[i][j];
    }
}
