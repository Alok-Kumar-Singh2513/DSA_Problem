package Subsequence;

public class o322_Coin_Change {
   public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Integer[][] dp = new Integer[n][amount + 1];
        int result = helper(n - 1, amount, coins, dp);
        return result >= 1000000000 ? -1 : result;
    }

    private static int helper(int index, int amount, int[] coins, Integer[][] dp) {
        // Base case: only use coins[0]
        if (index == 0) {
            if (amount % coins[0] == 0) return amount / coins[0];
            return 1000000000;  
        }

        if (dp[index][amount] != null) return dp[index][amount];

        int notTake = helper(index - 1, amount, coins, dp);
        int take = 1000000000;
        if (coins[index] <= amount) {
            take = 1 + helper(index, amount - coins[index], coins, dp);
        }

        return dp[index][amount] = Math.min(take, notTake);
    }
}
