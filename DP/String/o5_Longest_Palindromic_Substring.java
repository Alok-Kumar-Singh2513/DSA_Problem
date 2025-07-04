package String;

public class o5_Longest_Palindromic_Substring {
   public static String longestPalindrome(String s) {
    // Memoization
    int n = s.length();
    boolean[][] dp = new boolean[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            dp[i][j] = false;
        }
    }
    String longestPalindrome = "";

    // memoization
    for(int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
            if (isPalindrome(s, i, j, dp)) {
                String currentPalindrome = s.substring(i, j + 1);
                if (currentPalindrome.length() > longestPalindrome.length()) {
                    longestPalindrome = currentPalindrome;
                }
            }
        }
    }
    return longestPalindrome;

}
   public static boolean isPalindrome(String s, int start, int end, boolean[][] dp) {
        if (start >= end) return true;
        if (dp[start][end] != false) return dp[start][end];
        boolean result = (s.charAt(start) == s.charAt(end)) && isPalindrome(s, start + 1, end - 1, dp);
        dp[start][end] = result;
        return result;
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s)); // Output: "bab" or "aba"
    }
}
