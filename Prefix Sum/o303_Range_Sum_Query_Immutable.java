// package Prefix Sum;

public class o303_Range_Sum_Query_Immutable {
  private int[] prefixSum;

    public o303_Range_Sum_Query_Immutable(int[] nums) {
        int n = nums.length;
        prefixSum = new int[n + 1];
    
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        // Return the sum from left to right using the prefix sum array
        return prefixSum[right + 1] - prefixSum[left];
    }
  }