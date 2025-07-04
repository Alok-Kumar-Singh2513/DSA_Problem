// Description: This code counts the occurrences of a number in a sorted array that may contain duplicates.
// LeetCode Problem: Count Occurrences of a Number in a Sorted Array with Duplicates
// LeetCode Link: https://leetcode.com/problems/count-occurrences-of-a-number-in-a-sorted-array-with-duplicates/
// Time Complexity: O(log n) for each binary search, resulting in O(log n) + O(log n) = O(log n)
public class Count_occurrences_of_a_numbe_in_a_sorted_array_with_duplicates {
  public static int countOccurrences(int[] arr, int target) {
    int first = findFirstOccurrence(arr, target);
    if (first == -1) {
        return 0;
    }
    int last = findLastOccurrence(arr, target);
    return last - first + 1;
}

// Binary search to find the first occurrence of the target
public static int findFirstOccurrence(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;
    int result = -1;
    
    while (left <= right) {
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) {
            result = mid;
            right = mid - 1; // Keep searching left
        } else if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    
    return result;
}

// Binary search to find the last occurrence of the target
public static int findLastOccurrence(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;
    int result = -1;
    
    while (left <= right) {
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) {
            result = mid;
            left = mid + 1; // Keep searching right
        } else if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    
    return result;
}

public static void main(String[] args) {
    int[] arr = {1, 2, 2, 2, 3, 4, 5};
    int target = 2;
    int count = countOccurrences(arr, target);
    System.out.println("Count of " + target + " in the array: " + count);
    // Output: Count of 2 in the array: 3
}
}
