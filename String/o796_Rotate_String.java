package String;
// Description:
// Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
// A shift on s consists of moving the leftmost character of s to the rightmost position.
// For example, if s = "abcde", then it will be "bcdea" after one shift. It will be "cdeab" after two shifts, and so on.
public class o796_Rotate_String {
  public static boolean rotateString(String s, String goal) {

    return s.length() == goal.length() && (s + s).contains(goal);

  }

  public static void main(String[] args) {
    String s = "abcde";
    String goal = "cdeab";
    boolean result = rotateString(s, goal);
    System.out.println("Can s be rotated to get goal? " + result); // Output: true

    s = "abcde";
    goal = "abced";
    result = rotateString(s, goal);
    System.out.println("Can s be rotated to get goal? " + result); // Output: false
  }
}
