package String;

public class o115_Distinct_Subsequences {
  // Memoization approach
   public static int numDistinct(String s, String t) {
    int m = s.length();
    int n = t.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        dp[i][j] = -1; 
      }
    }

    return countDistinctSubsequences(s, t, m, n, dp);
  }
  private static int countDistinctSubsequences(String s, String t, int m, int n, int[][] dp) {
    if (n == 0) return 1; // If t is empty, there's one way to form it (by choosing nothing)
    if (m == 0) return 0; // If s is empty and t is not, no way to form t

    if (dp[m][n] != -1) return dp[m][n];

    if (s.charAt(m - 1) == t.charAt(n - 1)) {
      // Include the last character of s in the subsequence or exclude it
      dp[m][n] = countDistinctSubsequences(s, t, m - 1, n - 1, dp) + countDistinctSubsequences(s, t, m - 1, n, dp);
    } else {
      // Exclude the last character of s
      dp[m][n] = countDistinctSubsequences(s, t, m - 1, n, dp);
    }

    return dp[m][n];
    } 

  // Tabulation approach
  public static int numDistinctTabulation(String s, String t) {
    int m = s.length();
    int n = t.length();
    int[][] dp = new int[m + 1][n + 1];

    // Base case: If t is empty, there's one way to form it (by choosing nothing)
    for (int i = 0; i <= m; i++) {
      dp[i][0] = 1;
    }

    // Fill the dp table
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]; // Include or exclude the character
        } else {
          dp[i][j] = dp[i - 1][j]; // Exclude the character
        }
      }
    }

    return dp[m][n];
  }
   }
