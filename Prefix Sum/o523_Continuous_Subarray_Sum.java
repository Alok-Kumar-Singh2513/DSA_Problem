// package Prefix Sum;
import java.util.HashMap;
import java.util.Map;
// Continuous Subarray Sum
// size >= 2
// Sum % k == 0
public class o523_Continuous_Subarray_Sum {

  // By brush force
  public static boolean checkSubarraySum1(int[] nums, int k) {
    int n = nums.length;
    if (n < 2) return false; // At least two elements are required
    for (int i = 0; i < n - 1; i++) {
      int sum = nums[i];
      for (int j = i + 1; j < n; j++) {
        sum += nums[j];
        if (k == 0) {
          if (sum == 0) return true;
        } else if (sum % k == 0) {
          return true;
        }
      }
    }
    return false;
  }
  

  // By prefix sum and HashMap
   public static boolean checkSubarraySum(int[] nums, int k) {
    int n= nums.length;
    if (n < 2) return false; // At least two elements are required
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1); // Handle the case where the subarray starts from
    int sum=0;
    for(int i=0;i<n;i++){
      sum+=nums[i];
      int remainder = sum % k;
      if (remainder < 0) {
        remainder += k; // Ensure the remainder is non-negative
      }
      if(map.containsKey(remainder)){
        if(i-map.get(remainder) >=2) {
          return true;
         
        }
      }else{
        map.put(remainder, i); // Store the first occurrence of this remainder
      }
    }
    return false;
  }
}
