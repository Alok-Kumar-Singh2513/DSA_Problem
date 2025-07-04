package String;

public class o1328_Break_Palindrome {
  public static String breakPalindrome(String palindrome) {
    // Memoization
    if (palindrome.length() <= 1) return "";
    char[] chars = palindrome.toCharArray();
    boolean found = false;
    for (int i = 0; i < chars.length / 2; i++) {
      if (chars[i] != 'a') {
        chars[i] = 'a';
        found = true;
        break;
      }
    }
    if (!found) {
      // If all characters are 'a', change the last character to 'b'
      chars[chars.length - 1] = 'b';
    }
    return new String(chars);
  }
}
