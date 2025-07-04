package Subsequence;

public class Partitions_with_Given_Difference {
    static int MOD = 1000000007;

    public static int countPartitions(int[] arr, int d) {
        int total = 0;
        for (int num : arr) total += num;

        if ((total - d) < 0 || (total - d) % 2 != 0) return 0;

        int target = (total - d) / 2;
        int n = arr.length;
        Integer[][] dp = new Integer[n][target + 1];

        return countSubsetsMemo(n - 1, target, arr, dp);
    }

    public static int countSubsetsMemo(int index, int target, int[] arr, Integer[][] dp) {
        if (index == 0) {
            if (target == 0 && arr[0] == 0) return 2; // Include or exclude 0
            if (target == 0 || target == arr[0]) return 1;
            return 0;
        }

        if (dp[index][target] != null) return dp[index][target];

        int notTake = countSubsetsMemo(index - 1, target, arr, dp);
        int take = 0;
        if (arr[index] <= target) {
            take = countSubsetsMemo(index - 1, target - arr[index], arr, dp);
        }

        return dp[index][target] = (take + notTake) % MOD;
    }

}
