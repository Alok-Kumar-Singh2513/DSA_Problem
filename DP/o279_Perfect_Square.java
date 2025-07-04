// package DP;

import java.util.Arrays;

public class o279_Perfect_Square {
  public static int[] ar;

  public static int helper(int n) {
    if (n == 0) {
      return 0;
    }
    if (ar[n] != -1) {
      return ar[n];
    }

    int minCount = Integer.MAX_VALUE;
    for (int i = 1; i * i <= n; i++) {
      int result = 1 + helper(n - i * i);
      minCount = Math.min(minCount, result);
    }
    ar[n] = minCount;
    return minCount;
  }

  public static int numSquares(int n) {
    ar = new int[n + 1];
    Arrays.fill(ar, -1);
    return helper(n);
  }

  public static void main(String[] args) {
    int n = 12;
    System.out.println("Minimum number of perfect squares for " + n + ": " + numSquares(n));

  }
}
