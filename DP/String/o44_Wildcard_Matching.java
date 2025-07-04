package String;

public class o44_Wildcard_Matching {
  // memoization approach
  public static boolean isMatchMemo(String s, String p) {
    int n = s.length();
    int m = p.length();
    Boolean[][] dp = new Boolean[n + 1][m + 1];

    return isMatchUtil(s, p, n, m, dp);
  }

  public static boolean isMatch(String s, String p) {

    int n = s.length();
    int m = p.length();
    boolean[][] dp = new boolean[n + 1][m + 1];

    // Base case
    dp[0][0] = true; // Both strings are empty

    // Handle patterns with leading '*'
    for (int j = 1; j <= m; j++) {
      if (p.charAt(j - 1) == '*') {
        dp[0][j] = dp[0][j - 1]; // '*' can match an empty string
      }
    }

    // Fill the dp table
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (p.charAt(j - 1) == '*') {
          dp[i][j] = dp[i - 1][j] || dp[i][j - 1]; // '*' can match zero or more characters
        } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1]; // Match single character or '?'
        }
      }
    }

    return dp[n][m];
  }
  private static boolean isMatchUtil(String s, String p, int n, int m, Boolean[][] dp) {
    // Base case
    if (m == 0) return n == 0; // If pattern is empty, string must also be empty
    if (n == 0) {
      // If string is empty, pattern must be all '*' to match
      for (int j = 0; j < m; j++) {
        if (p.charAt(j) != '*') return false;
      }
      return true;
    }

    if (dp[n][m] != null) return dp[n][m];

    if (p.charAt(m - 1) == '*') {
      // '*' can match zero or more characters
      dp[n][m] = isMatchUtil(s, p, n - 1, m, dp) || isMatchUtil(s, p, n, m - 1, dp);
    } else if (p.charAt(m - 1) == '?' || s.charAt(n - 1) == p.charAt(m - 1)) {
      // Match single character or '?'
      dp[n][m] = isMatchUtil(s, p, n - 1, m - 1, dp);
    } else {
      dp[n][m] = false; // Characters do not match
    }

    return dp[n][m];
  }
}
