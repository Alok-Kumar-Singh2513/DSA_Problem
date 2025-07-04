package String;

import java.util.*;

public class Print_all_LCS_sequences {
  public static List<String> allLCS(String s1, String s2) {
    // Code here
    int t1 = s1.length();
    int t2 = s2.length();
    int[][] dp = new int[t1 + 1][t2 + 1];
    for (int row = 0; row <= t1; row++) {
      for (int col = 0; col <= t2; col++) {
        if (row == 0 || col == 0) {
          dp[row][col] = 0;
        } else if (s1.charAt(row - 1) == s2.charAt(col - 1)) {
          dp[row][col] = 1 + dp[row - 1][col - 1];
        } else {
          dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
        }
      }
    }
    StringBuilder lcs = new StringBuilder();
    int row = t1, col = t2;

    while (row > 0 && col > 0) {
      if (s1.charAt(row - 1) == s2.charAt(col - 1)) {
        lcs.append(s1.charAt(row - 1));
        row--;
        col--;
      } else if (dp[row - 1][col] >= dp[row][col - 1]) {
        row--;
      } else {
        col--;
      }
    }

    lcs.reverse(); // Since we built the string backwards
    return List.of(lcs.toString());

  }

}
