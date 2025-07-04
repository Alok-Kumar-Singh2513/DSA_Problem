import java.util.*;

public class o46_Two_Sum {
  public static int[] findTwoSum(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;
            if (set.contains(complement)) {
                // If complement is found in the set, return the pair
                return new int[] {complement, num};
            }
            set.add(num);  // Add current element to set
        }
        
        return new int[] {};  // Return empty array if no pair is found
    }
  

 
}
