// package Subset_Sum_&_01_Knapsack;
import java.util.Arrays;
public class o518_Coin_Change_II {
  static int countWaysToMakeChangeUtil(int[] arr, int ind, int T, int[][] dp) {
       
        if (ind == 0) {
            // If T is divisible by the first element of the array, return 1, else return 0
            if (T % arr[0] == 0){
                return 1;
            }
            else{
                return 0;
            }
        }

        if (dp[ind][T] != -1){
            return dp[ind][T];
        }

        // Calculate the number of ways without taking the current element
        int notTaken = countWaysToMakeChangeUtil(arr, ind - 1, T, dp);

        // Initialize the number of ways taking the current element as 0
        int taken = 0;

        // If the current element is less than or equal to T, calculate 'taken'
        if (arr[ind] <= T)
            taken = countWaysToMakeChangeUtil(arr, ind, T - arr[ind], dp);

        // Store the result in the dp array and return it
        return dp[ind][T] = notTaken + taken;
    }
    public  static int change(int amount, int[] coins) {
       int n=coins.length;
        int dp[][] = new int[n][amount + 1];
        for (int row[] : dp){
            Arrays.fill(row, -1);
        }

        return countWaysToMakeChangeUtil(coins, n - 1, amount, dp);
    }
}
