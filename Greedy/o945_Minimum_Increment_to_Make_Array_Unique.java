package Greedy;

import java.util.Arrays;

public class o945_Minimum_Increment_to_Make_Array_Unique {
  public static int minIncrementForUnique(int[] nums) {
    int count = 0;
    int n = nums.length;
    Arrays.sort(nums);
    for (int i = 1; i < n; i++) {
      if (nums[i] <= nums[i - 1]) {
        count += nums[i - 1] + 1 - nums[i];
        nums[i] = nums[i - 1] + 1;
      }
      
    }
    return count;
  }
}
