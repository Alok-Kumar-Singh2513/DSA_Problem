// Description: Search in Rotated Sorted Array II
// LeetCode Problem: 81. Search in Rotated Sorted Array II
// LeetCode Link: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
// Time Complexity: O(log n) in average case, O(n) in worst case due to duplicates
public class o81_Search_in_Rotated_Sorted_Array_II {
  public static boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
    
            if (nums[mid] == target) return true; 
            
            // Handle duplicates: Move pointers if start, mid, and end are equal
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
                continue;
            }

            // Left half is sorted
            if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target < nums[mid]) { // Check if target is in the left sorted half
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (target > nums[mid] && target <= nums[end]) { // Check if target is in the right sorted half
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false; 
    }
    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 0;
        boolean result = search(nums, target);
        System.out.println("Is the target " + target + " present in the rotated sorted array? " + result);
        // Output: true
    
    }
}
