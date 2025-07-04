package String;

public class Shortest_Common_Supersequence {
   public static int shortestCommonSupersequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }

        int lcsLength = LCS(s1, s2, n, m, dp);
        return n + m - lcsLength;
    }

    private static int LCS(String s1, String s2, int i, int j, int[][] dp) {
        // Base case
        if (i == 0 || j == 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return dp[i][j] = 1 + LCS(s1, s2, i - 1, j - 1, dp);
        } else {
            return dp[i][j] = Math.max(LCS(s1, s2, i - 1, j, dp), LCS(s1, s2, i, j - 1, dp));
        }
    }
}
