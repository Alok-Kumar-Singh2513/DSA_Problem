import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class o37_CombinationsSum2 {
   public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Important to handle duplicates
        backtrack(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int start, int[] nums, int target, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1]) continue;

            if (nums[i] > target) break; // Prune

            current.add(nums[i]);
            backtrack(i + 1, nums, target - nums[i], current, result); // i+1 to not reuse
            current.remove(current.size() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> combinations = combinationSum2(candidates, target);
        System.out.println("Unique combinations summing to " + target + ":");
        for (List<Integer> comb : combinations) {
            System.out.println(comb);
        }
    }
}
