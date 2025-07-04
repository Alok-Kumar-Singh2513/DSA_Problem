package Sliding_Window;
import java.util.*;
// import java.util.Map;

public class o992_Subarrays_with_K_Different_Integers {
  private static int atMostKDistinct(int[] nums, int k) {
    int count = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    int left = 0;

    for (int right = 0; right < nums.length; right++) {
        // Increment the count of the current number
        map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

        // Shrink the window if the number of distinct elements exceeds `k`
        while (map.size() > k) {
            map.put(nums[left], map.get(nums[left]) - 1);
            if (map.get(nums[left]) == 0) {
                map.remove(nums[left]);
            }
            left++;
        }

        // The number of subarrays ending at `right` is `right - left + 1`
        count += (right - left + 1);
    }

    return count;
}

public static int subarraysWithKDistinct(int[] nums, int k) {
   
    return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
}
}
