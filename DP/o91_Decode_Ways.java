import java.util.Arrays;

public class o91_Decode_Ways {
  public static int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(0, s, n, dp);
    }

    public static int solve(int i, String s, int n, int[] dp) {
        if (i == n) return 1;
        if (s.charAt(i) == '0') return 0;

        if (dp[i] != -1) return dp[i];

        int onlyOneChar = solve(i + 1, s, n, dp);
        int twoChars = 0;

        if (i + 1 < n) {
            if (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6')) {
                twoChars = solve(i + 2, s, n, dp);
            }
        }

        return dp[i] = onlyOneChar + twoChars;
    }
    public static void main(String[] args) {
        String s = "226";
        int result = numDecodings(s);
        System.out.println("Number of ways to decode the string: " + result);
        // output: 3
    }

}
