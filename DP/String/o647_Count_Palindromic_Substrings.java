package String;
public class o647_Count_Palindromic_Substrings {
  public static int countSubstrings(String s) {
    // Memo
    int n = s.length();
    boolean[][] dp = new boolean[n][n];
    for(int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            dp[i][j] = false; // Initialize the dp table
        }
    }
    int count = 0;
    // Fill the dp table
    for(int i=0;i<n;i++){
        for(int j=i;j<n;j++){
            if(isPalindrome(s, i, j, dp)){
                count++;
            }
        }
    }
    return count;
}

public static boolean isPalindrome(String s, int start, int end, boolean[][] dp) {
    if (start >= end) return true;
    if (dp[start][end] != false) return dp[start][end];
    boolean result = (s.charAt(start) == s.charAt(end)) && isPalindrome(s, start + 1, end - 1, dp);
    dp[start][end] = result;
    return result;
}

// By tabulation
public static int countSubstringsTabulation(String s) {
    int n = s.length();
    boolean[][] dp = new boolean[n][n];
    int count = 0;

    for (int len = 1; len <= n; len++) {
        for (int i = 0; i <= n - len; i++) {
            int j = i + len - 1;
            if (len == 1) {
                dp[i][j] = true;
            } else if (len == 2) {
                dp[i][j] = (s.charAt(i) == s.charAt(j));
            } else {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
            }
            if (dp[i][j]) count++;
        }
    }
    return count;
}

public static void main(String[] args) {
    String s = "abc";
    System.out.println(countSubstrings(s)); // Output: 3
    System.out.println(countSubstringsTabulation(s)); // Output: 3
}
}
