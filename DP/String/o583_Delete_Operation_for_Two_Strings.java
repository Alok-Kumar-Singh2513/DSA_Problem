package String;

public class o583_Delete_Operation_for_Two_Strings {
   public static int minDistance(String word1, String word2) {
    int n= word1.length();
    int m= word2.length();
    int[][] dp = new int[n + 1][m + 1];
   
    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= m; j++) {
            dp[i][j] = -1;
        }
    }

    int lengthWord1 = lcs(word1, word2, n, m, dp);
    return (n - lengthWord1) + (m - lengthWord1);
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
}
