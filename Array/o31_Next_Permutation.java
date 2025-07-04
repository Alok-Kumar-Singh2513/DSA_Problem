public class o31_Next_Permutation {
  public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        // Find the first decreasing element from the end
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // If the entire array is in descending order, reverse it to get the smallest permutation
        if (i < 0) {
            reverse(nums, 0, n - 1);
            return;
        }
        // Find the first element larger than nums[i] from the end
        int j = n - 1;
        while (j > i && nums[j] <= nums[i]) {
            j--;
        }
        // Swap nums[i] and nums[j]
        swap(nums, i, j);
        // Reverse the subarray from i + 1 to the end to get the next permutation
        reverse(nums, i + 1, n - 1);

  }
  public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
