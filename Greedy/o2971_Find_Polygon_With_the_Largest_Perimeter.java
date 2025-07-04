package Greedy;

import java.util.Arrays;

public class o2971_Find_Polygon_With_the_Largest_Perimeter {
    public static long largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);        
        long perimeter= 0;
        long remainingSidesSum= 0;
        for(int i=0;i<n;i++){
            if(nums[i]< remainingSidesSum){
              perimeter=remainingSidesSum+nums[i];
            }
            remainingSidesSum+= nums[i];
        }
        return perimeter==0? -1: perimeter;

    }
}
