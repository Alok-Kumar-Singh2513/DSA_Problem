package Sliding_Window;

public class o1004_Max_Consecutive_Ones_III {
   public int longestOnes(int[] nums, int k) {
        int right = 0;
        int left = 0;
        int zero = 0;
        int maxLen = 0;

        // Loop through the array with the right pointer
        while (right < nums.length) {
            if (nums[right] == 0) {
                zero++;  // Count the zeros encountered
            }

            // When the count of zeros exceeds k, move the left pointer
            while (zero > k) {
                if (nums[left] == 0) {
                    zero--;  // Decrease the zero count
                }
                left++;  // Move the left pointer forward to reduce the window size
            }

            // Calculate the length of the current valid window
            maxLen = Math.max(maxLen, right - left + 1);
            right++;  // Move the right pointer forward
        }

        return maxLen; 
    }
  public static void main(String[] args) {
    o1004_Max_Consecutive_Ones_III solution = new o1004_Max_Consecutive_Ones_III();
    int[] nums = {1, 1, 0, 0, 1, 1, 1, 0, 1};
    int k = 2;
    int result = solution.longestOnes(nums, k);
    System.out.println("The length of the longest subarray with at most " + k + " zeros is: " + result);
  }
}
