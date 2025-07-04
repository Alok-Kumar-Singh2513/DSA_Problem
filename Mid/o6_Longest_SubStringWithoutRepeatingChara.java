import java.util.HashSet;

public class o6_Longest_SubStringWithoutRepeatingChara {
  public static int lengthOfLongestSubstring(String s) {
    int n = s.length();
    int maxLength = 0;
    int left = 0;
    int right = 0;
    HashSet<Character> charSet = new HashSet<>();

    while (right < n) {
      if (!charSet.contains(s.charAt(right))) {
        charSet.add(s.charAt(right));
        maxLength = Math.max(maxLength, right - left + 1);
        right++;
      } else {
        charSet.remove(s.charAt(left));
        left++;
      }
    }

    return maxLength;
  }
}
