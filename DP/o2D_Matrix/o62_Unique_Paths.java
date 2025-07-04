package o2D_Matrix;
import java.util.Arrays;
public class o62_Unique_Paths {
   public static int help(int[][] dp, int n, int m) {
      
        if (n == 0 && m == 0) return 1;
        
        if (n < 0 || m < 0 ) return 0;
       
        if (dp[n][m] != -1) return dp[n][m];
        
        int up = help(dp, n - 1, m); 
        int left = help(dp, n, m - 1); 
        dp[n][m] = up + left;
        return dp[n][m];
    }

    public static int uniquePaths(int m, int n) {
        int dp[][] = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1); 
        }
        return help(dp, n - 1, m - 1); 
    }
}
