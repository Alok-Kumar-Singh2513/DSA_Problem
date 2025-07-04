// package DP;

import java.util.Arrays;

public class o509_Fibonacci_number {
  // By recursion
  // Time complexity: O(2^n)
  public static int fib(int n) {
    if (n <= 1) {
      return n;
    }
    return fib(n - 1) + fib(n - 2);
  }

  // By memoization
  // Time complexity: O(n)
  // Space complexity: O(n)
  public static int fibMemo(int n, int[] dp) {
    if (n <= 1) {
      return n;
    }
    if (dp[n] != -1) {
      return dp[n];
    }
    return dp[n] = fibMemo(n - 1, dp) + fibMemo(n - 2, dp);
  }
  // By tabulation
  // Time complexity: O(n)
  // Space complexity: O(n)
  public static int fibTab(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  // By space optimization
  // Time complexity: O(n)
  // Space complexity: O(1)
  public static int fibSpaceOpt(int n) {
    if (n <= 1) {
      return n;
    }
    int prev1 = 0, prev2 = 1, curr = 0;
    for (int i = 2; i <= n; i++) {
      curr = prev1 + prev2;
      prev1 = prev2;
      prev2 = curr;
    }
    return curr;
  }

  public static void main(String[] args) {
    int n = 10;
    System.out.println("Fibonacci number using recursion: " + fib(n));
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    System.out.println("Fibonacci number using memoization: " + fibMemo(n, dp));
    System.out.println("Fibonacci number using tabulation: " + fibTab(n));
  }
}
