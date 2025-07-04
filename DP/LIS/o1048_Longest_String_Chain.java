package LIS;
import java.util.Arrays;
public class o1048_Longest_String_Chain {
   public static int longestStrChain(String[] words) {
    int n = words.length;
    int dp[][]= new int[n][n + 1];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j <= n; j++) {
            dp[i][j] = -1;
        }
    }
    Arrays.sort(words, (a, b) -> a.length() - b.length());
    return longestStrChainUtil(words, 0, -1, dp);
}

private static int longestStrChainUtil(String[] words, int index, int prevIndex, int[][] dp) {
    if (index == words.length) return 0;

    if (prevIndex != -1 && dp[index][prevIndex + 1] != -1) return dp[index][prevIndex + 1];

    int notTake = longestStrChainUtil(words, index + 1, prevIndex, dp);

    int take = 0;
    if (prevIndex == -1 || isPredecessor(words[prevIndex], words[index])) {
        take = 1 + longestStrChainUtil(words, index + 1, index, dp);
    }

    dp[index][prevIndex + 1] = Math.max(take, notTake);
    return dp[index][prevIndex + 1];
  }
private static boolean isPredecessor(String prev, String curr) {
   int prevLen = prev.length();
    int currLen = curr.length();
    if(prevLen > currLen){
      return false;
    }
    if (currLen - prevLen != 1) {
        return false;
    }
    int i = 0, j = 0;
  
    while(i< prevLen && j < currLen) {
       if(prev.charAt(i) == curr.charAt(j)) {
            i++;
            j++;
        } else {
            j++;
        }
    }
    return i == prevLen; // If we have traversed all characters of prev
  }
}
