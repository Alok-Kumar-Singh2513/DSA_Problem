// package Dp;
import java.util. *;
public class Frog_Jump_Min_Energy {
  public static int frogJump (int height[],int n){
    // memo
    int[] dp = new int[n];
    Arrays.fill(dp, -1);
    return frogJumpUtil(height, n - 1, dp);


  }
  public static int frogJumpUtil(int height[],int n,int[]dp){
    if(n==0)return 0;
    int left=frogJumpUtil(height, n-1,dp)+Math.abs(height[n]-height[n-1]);
    int right=Integer.MAX_VALUE;
    right=frogJumpUtil(height, n-2,dp)+Math.abs(height[n]-height[n-2]);
    return Math.min(left, right);
  }

  // Tabulation
  public static int frogJumpTab (int height[],int n){
    int dp[]=new int[n];
    dp[0]=0;
    for(int i=1;i<n;i++){
      int first=dp[i-1]+Math.abs(dp[i]-dp[i-1]);
      int second=Integer.MAX_VALUE;
      if(i>1){
         second=dp[i-2]+Math.abs(dp[i]-dp[i-2]);
      }
      dp[i]=Math.min(first,second);
    }
    return dp[n];
  }
  public static void main(String[] args) {
    
  }
}
