// package DP;

public class o1416_Restore_The_Array {
  public static int mod = 1000000007;

  public static int numberOfArrays(String s, int k) {
    int n = s.length();
    int[] dp = new int[n + 1];
    dp[n] = 1;

    for (int i = 0; i < n; i++) {
      dp[i] = -1;
    }

    return solve(0, s, k, dp);
  }

  public static int solve(int currentIndex, String s, int k, int[] dp) {
    
    if (dp[currentIndex] != -1) {
      return dp[currentIndex];
    }

    int count = 0;
    for (int end = currentIndex + 1; end <= s.length(); end++) {
      String sub = s.substring(currentIndex, end);

      // Skip if the substring starts with '0' (unless it's just '0')
      if (sub.length() > 1 && sub.charAt(0) == '0') {
        continue;
      }

      long num = Long.parseLong(sub);
      if (num <= k) {
        count = (count + solve(end, s, k, dp)) % mod;
      }
    }

    dp[currentIndex] = count;
    return count;
  }

  public static void main(String[] args) {
    String s = "1000";
    int k = 10000;
    System.out.println(numberOfArrays(s, k)); // Expected Output: 1

    s = "1317";
    k = 2000;
    System.out.println(numberOfArrays(s, k)); // Expected Output: 8
  }
}
