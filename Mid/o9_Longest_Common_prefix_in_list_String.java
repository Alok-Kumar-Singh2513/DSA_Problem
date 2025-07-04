import java.util.Arrays;

public class o9_Longest_Common_prefix_in_list_String {

  // second method by sorting the array
  public static String longestCommonPrefix2(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    Arrays.sort(strs);
    String first = strs[0];
    String last = strs[strs.length - 1];
    int i = 0;
    while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
      i++;
    }
    return first.substring(0, i);
  }
}
