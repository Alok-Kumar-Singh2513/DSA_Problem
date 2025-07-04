// package Prefix Sum;
import java.util.*;

public class o1248_Count_Number_of_Nice_Subarrays {
  //  By prefix sum and HashMap and prefix work as count of odd numbers
  //  Time Complexity: O(n)
   public static int numberOfSubarrays(int[] nums, int k) {
    int result = 0;
    int count = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1); 
    for (int num : nums) {
      if (num % 2 == 1) {
        count++;
      }
      if (map.containsKey(count - k)) {
        result += map.get(count - k);
      }
      map.put(count, map.getOrDefault(count, 0) + 1);
    }
    return result;
  }

  //  By sliding window
  public static int numberOfSubarraysSlid(int[] nums, int k) {
     return help(nums,k)-help(nums,k-1);
    }
   public static int help(int []a, int k){
        if(k<0 )return 0;
        int left=0,right=0,sum=0,count=0;

        while(right<a.length){
            sum+=a[right]%2;

            while(sum> k){
                sum-=a[left]%2;
                left++;
            }
            count=count+(right-left+1);
            right++;

        }
        return count;

    }
}
