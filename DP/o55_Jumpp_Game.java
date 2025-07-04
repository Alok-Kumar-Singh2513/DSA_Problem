
import java.util.Arrays;

public class o55_Jumpp_Game {
  public boolean canJump(int[] nums) {
        // Memoization array to store results for subproblems
        int n = nums.length;
        boolean[] dp = new boolean[n];
        Arrays.fill(dp, false);
        return canJumpUtil(nums, 0, dp);
    }
  private boolean canJumpUtil(int[] nums, int index, boolean[] dp) {
        // If we reach or exceed the last index, we can jump
        if (index >= nums.length - 1) return true;
        // If we've already computed this subproblem, return the result
        if (dp[index]) return true;

        // Try all reachable indices from current position
        for (int i = 1; i <= nums[index]; i++) {
            if (canJumpUtil(nums, index + i, dp)) {
                dp[index] = true; // Mark this index as reachable
                return true;
            }
        }

        dp[index] = false; // Mark this index as not reachable
        return false;
    }
    public static void main(String[] args) {
      o55_Jumpp_Game game = new o55_Jumpp_Game();
      int[] nums = {2, 3, 1, 1, 4};
      System.out.println(game.canJump(nums)); // Output: true
    }
}
