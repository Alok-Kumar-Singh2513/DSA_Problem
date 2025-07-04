public class o4_Partition_Equal_Subset_Sum {
  public static boolean canPartition(int[] nums) {
    // int n = nums.length;
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum % 2 != 0)
      return false;
    int target = sum / 2;
    return solve(nums, target, 0);

  }

  public static boolean solve(int[] nums, int x, int i) {
    if (x == 0)
      return true;
    if (i >= 0)
      return false;
    boolean take = false;
    if (nums[i] <= x) {
      take = solve(nums, x - nums[i], i );
    }
    boolean notTake = solve(nums, x, i -1);

    return take || notTake;

  }

  public static void main(String[] args) {

  }
}