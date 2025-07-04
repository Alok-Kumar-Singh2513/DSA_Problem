package LIS;

import java.util.Arrays;

public class o673_Number_of_Longest_Increasing_Subsequence {
   static int[][] lenDp, countDp;

    static int LIS(int[] arr, int n, int ind, int prev_index) {
        if (ind == n) return 0;

        if (lenDp[ind][prev_index + 1] != -1) {
            return lenDp[ind][prev_index + 1];
        }

        int notTake = LIS(arr, n, ind + 1, prev_index);

        int take = 0;
        if (prev_index == -1 || arr[ind] > arr[prev_index]) {
            take = 1 + LIS(arr, n, ind + 1, ind);
        }

        lenDp[ind][prev_index + 1] = Math.max(take, notTake);
        return lenDp[ind][prev_index + 1];
    }

    static int count(int[] arr, int n, int ind, int prev_index, int targetLen) {
        if (ind == n) return (targetLen == 0) ? 1 : 0;

        if (countDp[ind][prev_index + 1] != -1) {
            return countDp[ind][prev_index + 1];
        }

        int total = 0;

        // Not taking current element
        total += count(arr, n, ind + 1, prev_index, targetLen);

        // Taking current element if valid
        if ((prev_index == -1 || arr[ind] > arr[prev_index]) && targetLen > 0) {
            total += count(arr, n, ind + 1, ind, targetLen - 1);
        }

        countDp[ind][prev_index + 1] = total;
        return total;
    }
      public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        lenDp = new int[n][n + 1];
        for (int[] row : lenDp) Arrays.fill(row, -1);

        int lisLen = LIS(nums, n, 0, -1);

        countDp = new int[n][n + 1];
        for (int[] row : countDp) Arrays.fill(row, -1);

        return count(nums, n, 0, -1, lisLen);
    }
}

