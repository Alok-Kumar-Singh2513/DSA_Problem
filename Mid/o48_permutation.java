import java.util.*;

public class o48_permutation {

    public static ArrayList<ArrayList<Integer>> nextPermutation(int[] nums, int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  
        boolean[] used = new boolean[n];
        ArrayList<Integer> temp = new ArrayList<>();
        backtrack(nums, used, temp, result);
        return result;
    }

    private static void backtrack(int[] nums, boolean[] used, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));  
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip used elements
            if (used[i]) continue;

            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            temp.add(nums[i]);
            used[i] = true;

            backtrack(nums, used, temp, result);

            // Backtrack
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int n = nums.length;
        ArrayList<ArrayList<Integer>> result = nextPermutation(nums, n);
        for (ArrayList<Integer> perm : result) {
            System.out.println(perm);
        }
    }
}
