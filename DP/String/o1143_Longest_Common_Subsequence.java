package String;
import java.util.Arrays;

public class o1143_Longest_Common_Subsequence {
   public static int longestCommonSubsequence(String text1, String text2) {
    int t1= text1.length();
    int t2= text2.length();
    int[][] dp = new int[t1 + 1][t2 + 1];
    for(int[]row: dp) {
       Arrays.fill(row, -1);
    }
    return lcs(text1, text2, t1, t2, dp);
   }
   public static int lcs(String s1,String s2,int t1,int t2,int[][]dp){
    if(t1==0 || t2==0){
        return 0;
    }
    if(dp[t1][t2] != -1) {
        return dp[t1][t2];
    }
    if(s1.charAt(t1 - 1) == s2.charAt(t2 - 1)){
        return dp[t1][t2] = 1 + lcs(s1, s2, t1 - 1, t2 - 1, dp);
    } else {
        return dp[t1][t2] = Math.max(lcs(s1, s2, t1 - 1, t2, dp), lcs(s1, s2, t1, t2 - 1, dp));
    }

   }

  //  by tabulation
   public static int lcsTabulation(String s1, String s2) {
       int t1 = s1.length();
       int t2 = s2.length();
       int[][] dp = new int[t1 + 1][t2 + 1];

       for (int i = 1; i <= t1; i++) {
           for (int j = 1; j <= t2; j++) {
               if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                   dp[i][j] = 1 + dp[i - 1][j - 1];
               } else {
                   dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
               }
           }
       }

       return dp[t1][t2];
   }
}
