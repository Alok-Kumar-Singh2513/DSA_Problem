package String;
import java.util.*;

public class Longest_Common_Substring {
   public static int longestCommonSubstr(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        Integer[][] dp = new Integer[m + 1][n + 1];
        for(Integer[] row : dp) {
           Arrays.fill(row, -1);
        }

        int maxLen = 0;
      
        // Tabulation approach
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLen = Math.max(maxLen, dp[i][j]);
                } else {
                    dp[i][j] = 0; 
                }
            }
        }
        return maxLen;
    }

 
}
