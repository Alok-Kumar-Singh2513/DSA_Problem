public class o1752_Check_if_Array_Is_Sorted_and_Rotated {
  public static boolean check(int[] nums) {
      int count = 0;
      int n = nums.length;
      for (int i = 0; i < n; i++) {
          if (nums[i] < nums[(i + 1) % n]) {
              count++;
          }
      }

      return count <= 1;
  }

  
  public static void main(String[] args) {
    int arr[] = { 1, 2, 3, 4, 5 };
 
    boolean isSortedAndRotated = check(arr);
    System.out.println("The array is sorted and rotated: " + isSortedAndRotated);
  }
  
}
