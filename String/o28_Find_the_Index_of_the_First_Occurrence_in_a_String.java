package String;

public class o28_Find_the_Index_of_the_First_Occurrence_in_a_String {
  public static int strStr(String haystack, String needle) {

    int m = haystack.length();
    int n = needle.length();

    // Edge case: if needle is empty, return 0
    if (n == 0) {
      return 0;
    }

    // Loop through the haystack
    for (int i = 0; i <= m - n; i++) { // Ensure we don't exceed bounds
      int j;
      for (j = 0; j < n; j++) {
        if (haystack.charAt(i + j) != needle.charAt(j)) {
          break; // Mismatch found
        }
      }
      // If we completed the inner loop, we found a match
      if (j == n) {
        return i; // Return the starting index
      }
    }
    return -1; // No match found
  }

}
