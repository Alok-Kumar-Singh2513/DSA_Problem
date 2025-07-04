public class Square_Root {
   static int floorSqrt(int n) {
        // Your code here
        int left = 0, right = n, ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * mid == n) {
                return mid; // Perfect square case
            } else if (mid * mid < n) {
                ans = mid; // Update answer for floor value
                left = mid + 1; // Search in the right half
            } else {
              // mid * mid > n 
                right = mid - 1; // Search in the left half
            }
        }
        return ans; 
        
    }
    public static void main(String[] args) {
        int n = 16; 
        int result = floorSqrt(n);
        System.out.println("The floor square root of " + n + " is: " + result);
        // Output: The floor square root of 16 is: 4
    }
}
