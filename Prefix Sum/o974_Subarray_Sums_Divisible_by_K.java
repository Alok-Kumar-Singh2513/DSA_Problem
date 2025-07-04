// package Prefix Sum;
import java.util.HashMap;
import java.util.Map; 
public class o974_Subarray_Sums_Divisible_by_K {
  // n^2
  public int subarraysDivByK1(int[] nums, int k) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                 sum+=nums[j];
                if(sum%k==0){
                    count++;
                }
            }
        }
        return count;
        
    }

    // n : Prefix Sum
  public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int[] prefixSum = new int[nums.length + 1];
        
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        for (int i = 0; i < prefixSum.length; i++) {
          int sum=0;
            for (int j = i ; j < prefixSum.length; j++) {
                if(i==0){
                    sum = prefixSum[j];
                }else{
                    sum = prefixSum[j] - prefixSum[i - 1];
                }
                if(sum%k==0){
                    count++;
                }
            }
        }
        
        return count;
    }

    // n : Prefix Sum + HashMap
  public int subarraysDivByK2(int[] nums, int k) {
        int count = 0;
    
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); 
        int sum=0;
        
        for (int i = 0; i < nums.length; i++) {
            sum+= nums[i];
            int remainder=sum % k;
            // Handle negative remainders
            if (remainder < 0) {
                remainder += k; // Ensure the remainder is non-negative
            }
            count += map.getOrDefault(remainder, 0); // Count how many times this remainder has occurred
            map.put(remainder, map.getOrDefault(remainder, 0) + 1); // Increment the count of this remainder
        }
        
        return count;
    }


}
