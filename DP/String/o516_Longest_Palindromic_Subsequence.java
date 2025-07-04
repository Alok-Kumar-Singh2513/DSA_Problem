package String;

public class o516_Longest_Palindromic_Subsequence {
  public static int longestPalindromeSubseq(String s) {
    String rev = new StringBuilder(s).reverse().toString();
    int n = s.length();
    int m = s.length();
    int[][] dp = new int[n + 1][m + 1];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        dp[i][j] = -1;
      }
    }
   
    return lcs(s,rev , 0, 0, dp);
  }
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
}
