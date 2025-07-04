package String;

public class o72_Edit_Distance {
  // memoization approach
   public static int minDistance(String word1, String word2) {
    int n = word1.length();
    int m = word2.length();
    int[][] dp = new int[n + 1][m + 1];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        dp[i][j] = -1; 
      }
    }

    return minDistanceUtil(word1, word2, n, m, dp);
  }

  private static int minDistanceUtil(String word1, String word2, int n, int m, int[][] dp) {
    if (n == 0) return m; // If word1 is empty, insert all characters of word2
    if (m == 0) return n; // If word2 is empty, remove all characters of word1

    if (dp[n][m] != -1) return dp[n][m];

    if (word1.charAt(n - 1) == word2.charAt(m - 1)) {
      dp[n][m] = minDistanceUtil(word1, word2, n - 1, m - 1, dp);
    } else {
      int insert = minDistanceUtil(word1, word2, n, m - 1, dp);
      int delete = minDistanceUtil(word1, word2, n - 1, m, dp);
      int replace = minDistanceUtil(word1, word2, n - 1, m - 1, dp);
      dp[n][m] = 1 + Math.min(insert, Math.min(delete, replace));
    }

    return dp[n][m];
  }
  // Tabulation approach
  public static int minDistanceTabulation(String word1, String word2) {
    int n = word1.length();
    int m = word2.length();
    int[][] dp = new int[n + 1][m + 1];

    // Base cases
    for (int i = 0; i <= n; i++) {
      dp[i][0] = i; // Deleting all characters from word1
    }
    for (int j = 0; j <= m; j++) {
      dp[0][j] = j; // Inserting all characters to form word2
    }

    // Fill the dp table
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1]; // No operation needed
        } else {
          int insert = dp[i][j - 1];
          int delete = dp[i - 1][j];
          int replace = dp[i - 1][j - 1];
          dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
        }
      }
    }

    return dp[n][m];
  }
}
// Tabulation approach