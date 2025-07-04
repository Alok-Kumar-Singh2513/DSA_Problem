package Greedy;

public class o330_Patching_Array {
   public static int minPatches(int[] nums, int n) {
        int i=0;
        int patch=0;
        long maxReachable=0;
        while(maxReachable<n){
            if(i<nums.length && nums[i]<=maxReachable+1){
                maxReachable+=nums[i];
                i++;
            }else{
                patch++;
                maxReachable+=maxReachable+1;
            }
        }
        return patch;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 31, 33};
        int n = 2147483647; 
        int result = minPatches(nums, n);
        System.out.println("Minimum patches required: " + result); // Output: 28
    }
  }
