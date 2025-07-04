package String;
// Description: Given an array of strings s, return the minimum number of columns that can be deleted to make all remaining columns in the array sorted in non-decreasing order.
// A column is said to be sorted in non-decreasing order if it is non-decreasing from top to bottom when read as a column of the array. 
public class o944_Delete_Columns_to_Make_Sorted {
  public static int minDeletionSize(String[] s) {
    int count = 0;
    int n = s.length;
    int m = s[0].length();

    for (int j = 0; j < m; j++) {
      for (int i = 1; i < n; i++) {
        if (s[i].charAt(j) < s[i - 1].charAt(j)) {
          count++;
          break;
        }
      }
    }

    return count;
  }
  public static void main(String[] args) {
    String[] s = {"cba", "daf", "ghi"};
    int result = minDeletionSize(s);
    System.out.println("Minimum number of columns to delete: " + result);
    // Output: 1
  }
}
