package Sliding_Window;

public class o930_Binary_Subarrays_With_Sum {
  public static int numSubarraysWithSum(int[] nums, int goal) {
    return atMost(nums, goal) - atMost(nums, goal - 1);
}

private static int atMost(int[] nums, int goal) {
  if (goal < 0) return 0;

  int left = 0, count = 0, sum = 0;
  
  for (int right = 0; right < nums.length; right++) {
      sum += nums[right]; 
  
      while (sum > goal) {
          sum -= nums[left];
          left++;
      }
      
      // The number of valid subarrays ending at index `right` is `right - left + 1`
      count =count+ right - left + 1;
  }
  
  return count;
}
public static void main(String[] args) {
    int[] nums = {1, 0, 1, 0, 1};
    int goal = 2;
    int result = numSubarraysWithSum(nums, goal);
    System.out.println("Number of subarrays with sum " + goal + ": " + result);
}
}
