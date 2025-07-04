package String;

import java.util.Arrays;

public class o516_Longest_Palindromic_Subsequence_Mathod_Second {
  public static int longestPalindromeSubseq(String s) {
    int n = s.length();
    int[][] dp = new int[n][n];
    for (int i = 0; i < n; i++) {
        Arrays.fill(dp[i], -1);
    }

    return solve(s, 0, n - 1, dp);
}

public static int solve(String s, int i, int j, int[][] dp) {
    // Base case: one character is a palindrome of length 1
    if (i > j) return 0;
    if (i == j) return 1;

    if (dp[i][j] != -1) return dp[i][j];

    if (s.charAt(i) == s.charAt(j)) {
        // If characters match, include them and move inward
        dp[i][j] = 2 + solve(s, i + 1, j - 1, dp);
    } else {
        // If not, take the maximum of skipping one character from either end
        dp[i][j] = Math.max(solve(s, i + 1, j, dp), solve(s, i, j - 1, dp));
    }

    return dp[i][j];
}

}
