// LeetCode Problem 162: Find Peak Element
public class o162_Find_Peak_Element {
  public static int findPeakElement(int[] nums) {
    int start = 0;
    int end = nums.length - 1;
    while (start < end) {
      int mid = (start + end) / 2;
      if (nums[mid] > nums[mid + 1]) {
        end = mid; // Move to the left half
      } else {
        start = mid + 1; // Move to the right half
      }
    }
    return start; // or return end, both are the same at this point 
  }
  public static void main(String[] args) {
    // num[i-1] < num[i] > num[i+1]
    int[] nums = {1, 2, 3, 1};
    int peakIndex = findPeakElement(nums);
    System.out.println("Peak element index: " + peakIndex); // Output: 2
    System.out.println("Peak element value: " + nums[peakIndex]); // Output: 3
  }
}
