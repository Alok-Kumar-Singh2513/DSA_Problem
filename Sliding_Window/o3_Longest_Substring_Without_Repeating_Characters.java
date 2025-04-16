package Sliding_Window;

public class o3_Longest_Substring_Without_Repeating_Characters {
  public static int lengthOfLongestSubstring(String s) {
    // By sliding window
    int n = s.length();
    int maxLength = 0;
    int left = 0;
    int[] charIndex = new int[128]; // Assuming ASCII characters
    for (int right = 0; right < n; right++) {
      char currentChar = s.charAt(right);
      if (charIndex[currentChar] > left) {
        left = charIndex[currentChar];
      }
      charIndex[currentChar] = right + 1; // Update the index of the character
      maxLength = Math.max(maxLength, right - left + 1);
    }
    return maxLength;

  }
    public static void main(String[] args) {
        String s = "abcabcbb";
        int length = lengthOfLongestSubstring(s);
        System.out.println("The length of the longest substring without repeating characters is: " + length);
    }
}
