import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class o1_Two_Sum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    // Second method n^2
    public static int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
    // Third method by Sorting the array
    public static int[] twoSum3(int[] nums, int target) {
        int[] original = nums.clone(); 
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                // Find the indices in the original array
                int index1 = findIndex(original, nums[left], left);
                int index2 = findIndex(original, nums[right], right);
                return new int[]{index1, index2};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};
    }
    public static int findIndex(int[] arr, int value, int excludeIndex) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value && i != excludeIndex) {
                return i;
            }
        }
        return -1; 
    }
    public static void main(String[] args) {
      
    }
  
}
