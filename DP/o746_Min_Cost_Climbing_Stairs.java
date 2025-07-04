import java.util.Arrays;

public class o746_Min_Cost_Climbing_Stairs {
  public static int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    return Math.min(minCostUtil(cost, 0, n - 1, dp), minCostUtil(cost, 0, n - 2, dp));
  }
  public static int minCostUtil(int[] cost, int i, int n, int[] dp) {
    if (i > n) return 0; // Base case: no cost if below ground level
    if (dp[i] != -1) return dp[i]; // Return already computed value

    // Calculate cost for the current step
    int oneStep = cost[i] + minCostUtil(cost, i - 1, n - 1, dp);
    int twoSteps = cost[i] + minCostUtil(cost, i - 2, n - 2, dp);

    // Store the result in dp array and return the minimum cost
    return dp[i] = Math.min(oneStep, twoSteps);
  }

  public static void main(String[] args) {
    int[] cost = {10, 15, 20};
    System.out.println(minCostClimbingStairs(cost)); // Output: 15
  }
  
}
