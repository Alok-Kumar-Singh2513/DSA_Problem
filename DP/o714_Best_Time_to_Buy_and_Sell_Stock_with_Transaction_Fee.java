// package DP;

public class o714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {
  public static int n;
  public static int[][] dp;
   public static int maxProfit(int[] prices, int fee) {
        n = prices.length;
        dp = new int[n + 1][2];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return solve(prices, 0, 1, fee);
    }
    public static int solve(int[] prices, int i, int buy, int fee) {
        if (i >= n) {
            return 0;
        }
        if (dp[i][buy] != -1) {
            return dp[i][buy];
        }
        if (buy == 1) {
            return dp[i][buy] = Math.max(-prices[i] + solve(prices, i + 1, 0, fee), solve(prices, i + 1, 1, fee));
        } else {
            return dp[i][buy] = Math.max(prices[i] - fee + solve(prices, i + 1, 1, fee), solve(prices, i + 1, 0, fee));
        }
    }
}
