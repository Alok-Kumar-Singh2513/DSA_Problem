import java.util.Arrays;

public class O1KnapsackProblem {

  public static int knapsack(int capacity, int[] val, int[] wt) {
    int n = val.length;
    int[][] dp = new int[n + 1][capacity + 1];
    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }

    return helper(n, capacity, val, wt, dp);
  }

  public static int helper(int i, int capacity, int[] val, int[] wt, int[][] dp) {
    if (i == 0 || capacity == 0) return 0;

    if (dp[i][capacity] != -1) return dp[i][capacity];

    if (wt[i - 1] <= capacity) {
      int include = val[i - 1] + helper(i - 1, capacity - wt[i - 1], val, wt, dp);
      int exclude = helper(i - 1, capacity, val, wt, dp);
      dp[i][capacity] = Math.max(include, exclude);
    } else {
      dp[i][capacity] = helper(i - 1, capacity, val, wt, dp);
    }

    return dp[i][capacity];
  }

  public static void main(String[] args) {
    int[] val = {60, 100, 120};
    int[] wt = {10, 20, 30};
    int capacity = 50;

    System.out.println(knapsack(capacity, val, wt)); // Output: 220
  }
}
