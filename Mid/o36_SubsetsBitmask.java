import java.util.ArrayList;
import java.util.List;

public class o36_SubsetsBitmask {
  public static List<List<Integer>> generateSubsets(int[] nums) {
        int n = nums.length;
        int totalSubsets = 1 << n; // 2^n subsets
        List<List<Integer>> result = new ArrayList<>();

        for (int mask = 0; mask < totalSubsets; mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }
            result.add(subset);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = generateSubsets(nums);
        System.out.println("All subsets using bitmasking:");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
