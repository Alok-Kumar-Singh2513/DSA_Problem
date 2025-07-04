package String;

import java.util.*;

public class o131_Palindrome_Partitioning {
   public static List<List<String>> partition(String s) {
        // Memoization
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = false;
            }
        }
        return partitionHelper(s, 0, dp);
    }

    public static List<List<String>> partitionHelper(String s, int start, boolean[][] dp) {
        List<List<String>> result = new ArrayList<>();
        if (start >= s.length()) {
            result.add(new ArrayList<>());
            return result;
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end, dp)) {
                String substring = s.substring(start, end + 1);
                for (List<String> partition : partitionHelper(s, end + 1, dp)) {
                    List<String> newPartition = new ArrayList<>();
                    newPartition.add(substring);
                    newPartition.addAll(partition);
                    result.add(newPartition);
                }
            }
        }
        return result;
    }

    public static boolean isPalindrome(String s, int start, int end, boolean[][] dp) {
        if (start >= end) return true;
        if (dp[start][end] != false) return dp[start][end];
        boolean result = (s.charAt(start) == s.charAt(end)) && isPalindrome(s, start + 1, end - 1, dp);
        dp[start][end] = result;
        return result;
    }
}
