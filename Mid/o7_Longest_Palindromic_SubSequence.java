public class o7_Longest_Palindromic_SubSequence {
  public static String longestPalindrome(String s) {
   int n = s.length();
   int maxLen=Integer.MIN_VALUE;
   int start=0;
   for(int i = 0; i < n; i++) {
     for (int j = i; j < n; j++) {
       if (solve(s,i,j) && (j-i+1)>maxLen) {
         maxLen=j-i+1;
         start=i;
       }
     }
   }
    return s.substring(start, start + maxLen);
  }
  public static boolean solve(String s,int left,int right) {
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}
