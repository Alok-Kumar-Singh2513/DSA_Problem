package LIS;

import java.util.Arrays;

public class o646_Maximum_Length_of_Pair_Chain {
   public static int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        // Sort pairs to ensure increasing order (optional but helps pruning)
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return findLongestChainUtil(pairs, 0, -1, dp); 
    }

    private static int findLongestChainUtil(int[][] pairs, int index, int prevEnd, int[][] dp) {
        if (index == pairs.length) return 0;

        if (prevEnd != -1 && dp[index][prevEnd + 1] != -1) return dp[index][prevEnd + 1];

        int notTake = findLongestChainUtil(pairs, index + 1, prevEnd, dp);

        int take = 0;
        if (prevEnd == -1 || pairs[index][0] > pairs[prevEnd][1]) {
            take = 1 + findLongestChainUtil(pairs, index + 1, index, dp);
        }

        dp[index][prevEnd + 1] = Math.max(take, notTake);
        return dp[index][prevEnd + 1];
    }
}