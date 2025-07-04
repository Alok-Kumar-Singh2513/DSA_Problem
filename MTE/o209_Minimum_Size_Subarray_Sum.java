package MTE;

public class o209_Minimum_Size_Subarray_Sum {
  public static int minSubArrayLen(int target, int[] nums) {
    int l = 0, n = nums.length;
    long s = 0;
   int ans = Integer.MAX_VALUE;

    for (int r = 0; r < n; ++r) {
        s += nums[r];
        while (s >= target) {
            ans = Math.min(ans, r - l + 1);
            s -= nums[l++];
        }
    }
    return ans > n ? 0 : ans;
}
public static void main(String[] args) {
  
}
}
