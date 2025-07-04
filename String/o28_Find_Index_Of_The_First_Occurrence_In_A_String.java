package String;

public class o28_Find_Index_Of_The_First_Occurrence_In_A_String {
  public static int strStr(String haystack, String needle) {
    if (needle.isEmpty()) {
      return 0;
    }
    int n = haystack.length();
    int m = needle.length();
    for (int i = 0; i <= n - m; i++) {
      int j;
      for (j = 0; j < m; j++) {
        if (haystack.charAt(i + j) != needle.charAt(j)) {
          break;
        }
      }
      if (j == m) {
        return i;
      }
    }
    return -1;
  }
  public static void main(String[] args) {
    String haystack = "hello";
    String needle = "ll";
    int result = strStr(haystack, needle);
    System.out.println("The index of the first occurrence of '" + needle + "' in '" + haystack + "' is: " + result);
    // Output: 2
  }
}
