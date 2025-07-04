

import java.util.Arrays;

public class o1547_Minimum_Cost_to_Cut_a_Stick {
  public static int m;
  public static int[][] dp;

  public static int minCost(int n, int[] cuts) {
    m = cuts.length;
    Arrays.sort(cuts);

    // Create a new array to include the endpoints
    int[] newCuts = new int[m + 2];
    newCuts[0] = 0;
    newCuts[m + 1] = n;
    for (int i = 1; i <= m; i++) {
      newCuts[i] = cuts[i - 1];
    }

    cuts = newCuts;
    m += 2; // now cuts.length = m

    // FIX: Initialize dp based on number of cuts, not stick length
    dp = new int[m][m];
    for (int i = 0; i < m; i++) {
      Arrays.fill(dp[i], -1);
    }

    return solve(cuts, 0, m - 1);
  }

  public static int solve(int[] cuts, int left, int right) {
    if (right - left <= 1)
      return 0;
    if (dp[left][right] != -1)
      return dp[left][right];

    int ans = Integer.MAX_VALUE;
    for (int i = left + 1; i < right; i++) {
      int cost = cuts[right] - cuts[left]
          + solve(cuts, left, i)
          + solve(cuts, i, right);
      ans = Math.min(ans, cost);
    }

    return dp[left][right] = ans;
  }

  public static void main(String[] args) {

    int n = 7;
    int[] cuts = { 1, 3, 4, 5 };
    System.out.println(minCost(n, cuts)); // Expected Output: 16

  }

}
