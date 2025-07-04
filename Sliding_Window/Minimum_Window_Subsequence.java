package Sliding_Window;

public class Minimum_Window_Subsequence {
  public static String minWindow(String s, String t) {
    if (s.length() < t.length()) return "";
    
    int[] charCount = new int[128]; // Assuming ASCII characters
    
    for (char c : t.toCharArray()) {
      charCount[c]++;
    }
    
    int left = 0, right = 0, minLength = Integer.MAX_VALUE, minLeft = 0;
    int requiredChars = t.length();
    
    while (right < s.length()) {
      char currentChar = s.charAt(right);
      if (charCount[currentChar] > 0) {
        requiredChars--;
      }
      charCount[currentChar]--;
      right++;
      
      while (requiredChars == 0) {
        if (right - left < minLength) {
          minLength = right - left;
          minLeft = left;
        }
        
        char leftChar = s.charAt(left);
        charCount[leftChar]++;
        if (charCount[leftChar] > 0) {
          requiredChars++;
        }
        left++;
      }
    }
    
    return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
  }
}
