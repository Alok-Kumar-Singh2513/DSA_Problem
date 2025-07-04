// package Subset_Sum_&_01_Knapsack;

public class Subset_Sum_Problem {
  public static boolean help(int index, int target, int[] arr, Boolean[][] dp) {
      
        if (target == 0) return true;
        if (index == 0) return arr[index] == target; 
      
        if (dp[index][target] != null) return dp[index][target];
  
        boolean notTake = help(index - 1, target, arr, dp);
        boolean take = false;
        if (target >= arr[index]) {
            take = help(index - 1, target - arr[index], arr, dp);
        }

        dp[index][target] = take || notTake;

        return dp[index][target];
    }

    static boolean isSubsetSum(int[] arr, int sum) {
        Boolean[][] dp = new Boolean[arr.length][sum + 1]; 
        return help(arr.length - 1, sum, arr, dp);
    }
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        if (isSubsetSum(arr, sum)) {
            System.out.println("Found a subset with the given sum");
        } else {
            System.out.println("No subset with the given sum");
        }
    }
}
