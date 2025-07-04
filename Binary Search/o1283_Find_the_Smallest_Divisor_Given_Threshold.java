public class o1283_Find_the_Smallest_Divisor_Given_Threshold {
  public static int smallestDivisor(int[] nums, int threshold) {
    int maxVal = 0;
    for (int num : nums) {
      if (num > maxVal) {
        maxVal = num;
      }
    }

    int left = 1;
    int right = maxVal;

    int ans = maxVal;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (calculateSum(nums, mid) <= threshold) {
        ans = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return ans;
  }

  private static int calculateSum(int[] nums, int divisor) {
    int sum = 0;
    for (int num : nums) {
      sum += Math.ceil((double) num / divisor);
    }
    return sum;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 5, 9 };
    int threshold = 6;
    int result = smallestDivisor(nums, threshold);
    System.out.println("Smallest divisor: " + result); // Output: 5
  }
}
