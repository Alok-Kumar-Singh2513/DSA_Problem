package String;

import java.util.Arrays;

public class o1312_Minimum_Insertion_Steps_to_Make_String_Palindrome {
    public static int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(s, 0, n - 1, dp);
    }

    public static int solve(String s, int i, int j, int[][] dp) {
        // Base case: if string is empty or has one character, it's already a palindrome
        if (i >= j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = solve(s, i + 1, j - 1, dp);
        } else {
            // Otherwise, insert a character to match and move pointers accordingly
            int insertLeft = solve(s, i + 1, j, dp);
            int insertRight = solve(s, i, j - 1, dp);
            dp[i][j] = 1 + Math.min(insertLeft, insertRight);
        }

        return dp[i][j];
    }

    public static void main(String[] args) {
        String s = "zzazz";
        System.out.println("Minimum insertions to make the string palindrome: " + minInsertions(s)); // Output: 0
        s = "mbadm";
        System.out.println("Minimum insertions to make the string palindrome: " + minInsertions(s)); // Output: 2
        s = "leetcode";
        System.out.println("Minimum insertions to make the string palindrome: " + minInsertions(s)); // Output: 5
    }
}
