// package DP;

public class o1143_Longest_Common_Subsequence {
  public static int longestCommonSubsequence(String text1, String text2) {
    int n = text1.length();
    int m = text2.length();
    int[][] dp = new int[n + 1][m + 1];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        dp[i][j] = -1;
      }
    }

    return lcs(text1, text2, 0, 0, dp);
  }
// time complexity O(n*m) and space complexity O(n*m)
  // memoization  
  public static int lcs(String s1, String s2, int i, int j, int[][] dp) {
    if (i >= s1.length() || j >= s2.length()) {
      return 0;
    }
    if (dp[i][j] != -1) {
      return dp[i][j];
    }
    if (s1.charAt(i) == s2.charAt(j)) {
      return dp[i][j] = 1 + lcs(s1, s2, i + 1, j + 1, dp);
    } else {
      return dp[i][j] = Math.max(lcs(s1, s2, i + 1, j, dp), lcs(s1, s2, i, j + 1, dp));
    }

  }

  // by tabulation
  public static int lcsTabulation(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();
    int[][] dp = new int[n + 1][m + 1];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[n][m];
  }

}
