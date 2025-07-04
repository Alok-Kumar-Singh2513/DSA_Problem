package String;

public class o456_132_Pattern {
   public static boolean find132pattern(int[] nums) {
        // Memoization
        if (nums == null || nums.length < 3) {
            return false;
        }
        int n = nums.length;
        int dp[] = new int[n];
        return find132PatternHelper(nums, dp, n);
    }
    public static boolean find132PatternHelper(int[] nums, int[] dp, int n) {
          // Initialize the dp array
          for (int i = 0; i < n; i++) {
              dp[i] = Integer.MIN_VALUE;
          }
          int min = nums[0];
          for (int j = 1; j < n; j++) {
              if (nums[j] > min) {
                  for (int k = j + 1; k < n; k++) {
                      if (nums[k] < nums[j] && nums[k] > min) {
                          return true;
                      }
                  }
              }
              min = Math.min(min, nums[j]);
          }
          return false;
      } 
}
