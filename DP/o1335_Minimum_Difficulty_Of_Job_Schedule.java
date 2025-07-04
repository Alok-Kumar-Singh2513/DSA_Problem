// package DP;

public class o1335_Minimum_Difficulty_Of_Job_Schedule {
  public static int[][] dp;
  public static int minDifficulty(int[] jobDifficulty, int d) {
    int n=jobDifficulty.length;
    if (n < d) return -1;
    dp = new int[n][d + 1];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= d; j++) {
        dp[i][j] = -1;
      }
    }
    return help(jobDifficulty, 0, d);
  }
  public static int help(int[] jobDifficulty,int i,int day){
    int n=jobDifficulty.length;
    if(day==1){
      int max=0;
      for(int j=i;j<n;j++){
        max=Math.max(max,jobDifficulty[j]);
      }
      return max;

    }

    if(dp[i][day]!=-1) return dp[i][day];
    int ans=Integer.MAX_VALUE;
    int max=0;
    for(int j=i;j<n-day+1;j++){
      max=Math.max(max,jobDifficulty[j]);
      int result=max+help(jobDifficulty,j+1,day-1);
      ans=Math.min(ans,result);
    }
    return dp[i][day]=ans;
  }

}
