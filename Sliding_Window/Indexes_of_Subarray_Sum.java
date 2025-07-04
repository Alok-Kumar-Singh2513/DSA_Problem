package Sliding_Window;

import java.util.ArrayList;

public class Indexes_of_Subarray_Sum {
   static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;
        int currentSum = 0;

        // The 'left' pointer, indicating the start of the current window
        int leftPointer = 0; 

        // The 'right' pointer, indicating the end of the current window
        for (int rightPointer = 0; rightPointer < n; rightPointer++) {
            currentSum += arr[rightPointer]; // Expand the window to the right

            // If currentSum exceeds the target, shrink the window from the left
            while (currentSum > target && leftPointer <= rightPointer) {
                currentSum -= arr[leftPointer]; // Subtract element from the left
                leftPointer++;                 // Move the left pointer to the right
            }

            // If currentSum equals the target, we found a subarray
            if (currentSum == target) {
                // Return 1-based indexing as often required in problems
                result.add(leftPointer + 1); 
                result.add(rightPointer + 1);
                return result; // Return the first found subarray
            }
        }

        // If no subarray is found, return -1 (or an empty list as per problem's usual convention)
        result.add(-1);
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 5};
        int target = 12;

        ArrayList<Integer> result = subarraySum(arr, target);
        if (result.size() == 2 && result.get(0) != -1) {
            System.out.println("Subarray found from index " + result.get(0) + " to " + result.get(1));
        } else {
            System.out.println("No subarray found with the given sum.");
        }
      
    }
}
