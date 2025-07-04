// Description: This code finds the nth root of a number m using binary search.
// LeetCode Problem: Not a specific problem, but a common algorithmic task.
// Time Complexity: O(log m * log n) where m is the number and n is the root to be found.
// LeetCode Link: Not applicable, as this is a general algorithm.
public class Find_nth_root_of_m {
  public static int nthRoot(int n, int m) {
        if (m == 0) return 0; 
        if (m == 1) return 1; 
        int left = 1; 
        int right = m; 
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if(help(mid, n) == m) {
                return mid; 
            } else if (help(mid, n) < m) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }
        return -1;
    }
    public static int help(int mid, int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= mid;
        }
        return result;
    }
    public static void main(String[] args) {
        int n = 3; // finding the 3rd root
        int m = 27; 
        int result = nthRoot(n, m);
        System.out.println("The " + n + "th root of " + m + " is: " + result);
        // Output: The 3th root of 27 is: 3
    }
}
