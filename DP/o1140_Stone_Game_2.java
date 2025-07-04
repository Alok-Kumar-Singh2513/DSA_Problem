// package DP;

// import java.util.*;

public class o1140_Stone_Game_2 {
  public static int n;
  public static int[][][] dp ;

  public static int stoneGameII(int[] piles) {

    dp = new int[2][piles.length + 1][piles.length + 1];

    for (int i = 0; i < piles.length + 1; i++) {
      for (int j = 0; j < piles.length + 1; j++) {
        dp[0][i][j]= -1;
        dp[1][i][j] = -1;
      }
    }
    n = piles.length;
    return solve(piles, 1, 0, 1);
  }

  public static int solve(int[] piles, int person, int i, int M) {
    if (i >= n){
      return 0;
    }
    if (dp[person][i][M] != -1) {
      return dp[person][i][M];
    }
    int result = (person == 1) ? -1 : Integer.MAX_VALUE;
    int stone = 0;
    for (int x = 1; x <= 2 * M && i + x - 1 < n; x++) {
      stone += piles[i + x - 1];
      if (person == 1) {
        result = Math.max(result, stone + solve(piles, 0, i + x, Math.max(M, x)));
      } else {
        result = Math.min(result, solve(piles, 1, i + x, Math.max(M, x)));

      }
    }
    return dp[person][i][M]= result;
  }
  public static void main(String[] args) {
    int[] piles = {2, 7, 9, 4, 4};
    System.out.println(stoneGameII(piles)); // Expected Output: 10

    
  }
 

 
}
 