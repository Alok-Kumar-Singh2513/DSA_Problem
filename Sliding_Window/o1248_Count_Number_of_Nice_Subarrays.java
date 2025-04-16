package Sliding_Window;

public class o1248_Count_Number_of_Nice_Subarrays {
  public int numberOfSubarrays(int[] nums, int k) {
    return help(nums, k) - help(nums, k - 1);
  }

  int help(int[] a, int k) {
    if (k < 0)
      return 0;
    int left = 0, right = 0, sum = 0, count = 0;

    while (right < a.length) {
      sum += a[right] % 2;

      while (sum > k) {
        sum -= a[left] % 2;
        left++;
      }
      count = count + (right - left + 1);
      right++;

    }
    return count;

  }

  public static void main(String[] args) {
    o1248_Count_Number_of_Nice_Subarrays obj = new o1248_Count_Number_of_Nice_Subarrays();
    int[] nums = { 1, 1, 2, 1, 1 };
    int k = 3;
    int result = obj.numberOfSubarrays(nums, k);
    System.out.println("Number of nice subarrays: " + result);
  }
}
