package String;
// Description: Given a string s of lower and upper case English letters. A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:
public class o1544_Make_The_String_Great {
  public String makeGood(String str) {
    StringBuilder s = new StringBuilder();
    for (char ch : str.toCharArray()) {
      if (s.length() > 0 && Math.abs(s.charAt(s.length() - 1) - ch) == 32) {
        s.deleteCharAt(s.length() - 1);
      } else {
        s.append(ch);
      }
    }

    return s.toString();
  }
  public static void main(String[] args) {
    o1544_Make_The_String_Great solution = new o1544_Make_The_String_Great();
    String str = "leEeetcode";
    String result = solution.makeGood(str);
    System.out.println("The modified string is: " + result); // Output: "leetcode"
  }
}
