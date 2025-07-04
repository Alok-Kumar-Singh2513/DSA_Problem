// Description: This code implements a binary search algorithm to find the index of a target value in a rotated sorted array.
// LeetCode Problem: 33. Search in Rotated Sorted Array
// time Complexity: O(log n)

public class o33_Search_in_Rotated_Sorted_Array {
  public static int search(int[] nums, int target) {
    int start=0;
    int end=nums.length-1;
    while(start<=end){
        int mid=(start+end)/2;
        if(target==nums[mid]){
            return mid;
        }

        // left sorted
        if(nums[start]<=nums[mid]){
         //    It means it is sorted array
          if(nums[start]<=target && target<=nums[mid]){
             end=mid-1;
          }
          else{
             start=mid+1;
          }
        }else{
        if(nums[mid]<=target && target<=nums[end]){
            start=mid+1;
        }else{
            end=mid-1;
        }
    } 
    }
    return -1;
 }
 public static void main(String[] args) {
    int[] nums = {4,5,6,7,0,1,2};
    int target = 0;
    int result = search(nums, target);
    System.out.println("The index of the target " + target + " is: " + result);
    // Output: 4
  
 }
}
