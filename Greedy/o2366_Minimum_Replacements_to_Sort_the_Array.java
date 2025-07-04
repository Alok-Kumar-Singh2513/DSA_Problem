package Greedy;

public class o2366_Minimum_Replacements_to_Sort_the_Array {

    public static long minimumReplacement(int[] nums) {
        int n = nums.length;
        long operations = 0;
        if (n == 1) return 0;

        for (int i = n - 2; i >= 0; i--) {
          // last value is greater then its previous value then continous
            if (nums[i] <= nums[i + 1]) {
                continue; // No replacement needed
            }

            // Calculate the number of parts needed
            long part = nums[i] / nums[i + 1];

            if (nums[i] % nums[i + 1] != 0) {
                part++; // If not divisible, need one extra part
            }

            operations += (part - 1); 
            nums[i] = nums[i] / (int) part; // Update to largest allowed part value
        }

        return operations;
    }
    public static void main(String[] args) {
      
    }
}
