// package DP;

import java.util.Arrays;

public class o1235_Maximum_Profit_In_Job_Scheduling {

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        // Sort jobs by end time
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);

        // Memoization array
        Integer[] memo = new Integer[n];

        return solve(jobs, 0, memo);
    }

    private static int solve(int[][] jobs, int index, Integer[] memo) {
        int n = jobs.length;
        if (index >= n) return 0;
        if (memo[index] != null) return memo[index];

        // Find next job that starts after current job ends
        int nextIndex = binarySearch(jobs, index + 1, jobs[index][1]);

        // Choose current job
        int take = jobs[index][2] + solve(jobs, nextIndex, memo);

        // Skip current job
        int skip = solve(jobs, index + 1, memo);

        return memo[index] = Math.max(take, skip);
    }

    // Binary search to find the first job whose startTime >= current job's endTime
    private static int binarySearch(int[][] jobs, int start, int currentJobEnd) {
        int low = start, high = jobs.length - 1;
        int result = jobs.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (jobs[mid][0] >= currentJobEnd) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] startTime = {1, 2, 3, 3};
        int[] endTime = {3, 4, 5, 6};
        int[] profit = {50, 10, 40, 70};
        System.out.println("Maximum Profit: " + jobScheduling(startTime, endTime, profit)); 
    }
}
