// package DP;

import java.util.Arrays;

public class o1406_Stone_Game_3 {
  public static int n;
  public static int[] dp;
   public static String stoneGameIII(int[] stoneValue) {
        n=stoneValue.length;
        dp=new int[n+1];
        Arrays.fill(dp,-1);
       
        int ans=solve(stoneValue,0);
        if(ans>0){
            return "Alice";
        }else if(ans<0){
            return "Bob";
        }else{
            return "Tie";
        }

    }
    public static int solve(int[] stones,int i){
        if(i>=n){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
       int result=stones[i]- solve(stones, i+1);
        if(i+1<n){
            result=Math.max(result, stones[i]+stones[i+1]-solve(stones, i+2));
        }
        if(i+2<n){
            result=Math.max(result, stones[i]+stones[i+1]+stones[i+2]-solve(stones, i+3));
        }
    
        return dp[i]=result;
    }
}
