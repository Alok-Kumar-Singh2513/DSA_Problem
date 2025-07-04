package Greedy;

public class o1793_Maximum_Score_of_Good_Subarray {
   public static int maximumScore(int[] nums, int k) {
    int n=nums.length;
    int left = k, right = k;
    int min = nums[k];
    int score = nums[k];
    while (left > 0 || right < n - 1) {
        if (left == 0) {
            right++;
        } else if (right == n - 1) {
            left--;
        } else if (nums[left - 1] < nums[right + 1]) {
            right++;
        } else {
            left--;
        }
        min = Math.min(min, Math.min(nums[left], nums[right]));
        score = Math.max(score, min * (right - left + 1));
        
    }
    return score;
  }
}
