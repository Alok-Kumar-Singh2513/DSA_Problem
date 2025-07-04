import java.util.*;
public class o45_Jump_Game_II_ {
   public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return jumpFrom(0, nums, dp);
    }

    private int jumpFrom(int index, int[] nums, int[] dp) {
        int n = nums.length;
        
        // Base case: if already at or beyond last index
        if (index >= n - 1) return 0;

        // Memoized result
        if (dp[index] != -1) return dp[index];

        // If no jump is possible from current position
        if (nums[index] == 0) return Integer.MAX_VALUE;

        int minJumps = Integer.MAX_VALUE;

        // Try all jump lengths from current position
        for (int jump = 1; jump <= nums[index]; jump++) {
            int nextIndex = index + jump;
            if (nextIndex < n) {
                int subResult = jumpFrom(nextIndex, nums, dp);
                if (subResult != Integer.MAX_VALUE) {
                    minJumps = Math.min(minJumps, 1 + subResult);
                }
            }
        }

        return dp[index] = minJumps;
    }

    public static void main(String[] args) {
        o45_Jump_Game_II_ sol = new o45_Jump_Game_II_();
        System.out.println(sol.jump(new int[]{2, 3, 1, 1, 4})); // Output: 2
        System.out.println(sol.jump(new int[]{2, 3, 0, 1, 4})); // Output: 2
    }
}
