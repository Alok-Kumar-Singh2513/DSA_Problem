// package DP;

public class o879_Profitable_Schemes {
  private static final int MOD = 1_000_000_007;

    public static int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length;
        int[][][] dp = new int[len + 1][n + 1][minProfit + 1];

        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return solve(0, 0, 0, minProfit, n, group, profit, dp);
    }

    public static int solve(int currentProjectIndex, int currentPeople, int currentProfit, int minProfit, int n, int[] group, int[] profit, int[][][] dp) {
        if (currentProjectIndex == group.length) {
            return currentProfit >= minProfit ? 1 : 0;
        }

        if (currentPeople > n) return 0;

        if (dp[currentProjectIndex][currentPeople][currentProfit] != -1) {
            return dp[currentProjectIndex][currentPeople][currentProfit];
        }

        // Option 1: Take the current project (if enough people remain)
        int take = 0;
        if (currentPeople + group[currentProjectIndex] <= n) {
            take = solve(currentProjectIndex + 1, currentPeople + group[currentProjectIndex], Math.min(currentProfit + profit[currentProjectIndex], minProfit), minProfit, n, group, profit, dp);
        }

        // Option 2: Skip the current project
        int notTake = solve(currentProjectIndex + 1, currentPeople, currentProfit, minProfit, n, group, profit, dp);

        return dp[currentProjectIndex][currentPeople][currentProfit] = (take + notTake) % MOD;
    }
}
