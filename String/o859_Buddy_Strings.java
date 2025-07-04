package String;
// Description:
// Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.

// Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].
public class o859_Buddy_Strings {
  public static boolean buddyStrings(String s, String goal) {
    int m = s.length(), n = goal.length();
    if (m != n) {
        return false;
    }
    int diff = 0;
    int[] cnt1 = new int[26];
    int[] cnt2 = new int[26];
    for (int i = 0; i < n; ++i) {
        int a = s.charAt(i), b = goal.charAt(i);
        ++cnt1[a - 'a'];
        ++cnt2[b - 'a'];
        if (a != b) {
            ++diff;
        }
    }
    boolean f = false;
    for (int i = 0; i < 26; ++i) {
        if (cnt1[i] != cnt2[i]) {
            return false;
        }
        if (cnt1[i] > 1) {
            f = true;
        }
    }
    return diff == 2 || (diff == 0 && f);
}
public static void main(String[] args) {
    String s = "ab";
    String goal = "ba";
    boolean result = buddyStrings(s, goal);
    System.out.println("Are the strings buddy strings? " + result);
    // Output: true
}
}
