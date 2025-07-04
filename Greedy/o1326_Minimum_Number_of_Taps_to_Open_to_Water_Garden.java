package Greedy;
// This question is very similar to jumping and cracker
public class o1326_Minimum_Number_of_Taps_to_Open_to_Water_Garden {
   public static int minTaps(int n, int[] ranges) {
      int[] maxReach = new int[n + 1];
      // visualize the garden as a line of n+1 points (0 to n):  In table form
      // maxReach[i] will store the farthest point that can be reached from point i
      // ranges[i] indicates the range of the tap at position i, which can water from
      for (int i = 0; i < ranges.length; i++) {
         int left = Math.max(0, i - ranges[i]);
         int right = Math.min(n, i + ranges[i]);
         maxReach[left] = Math.max(maxReach[left], right);
      }

      int taps = 0;
      int currentEnd = 0;
      int maxEnd = 0;

      for (int i = 0; i < n+1; i++) {
        if(i>maxEnd) {
            return -1; // If we reach a point that cannot be watered
         }
        
         if(i> currentEnd) {
            taps++; // We need to open a new tap
            currentEnd = maxEnd; // Move to the farthest point we can reach with the current tap
         }
          maxEnd = Math.max(maxEnd, maxReach[i]); // Update the farthest point we can reach

      }
      return taps;
    }
    public static void main(String[] args) {
      int n = 5;
      int[] ranges = {3,4,1,1,0,0};
      System.out.println(minTaps(n, ranges)); // Output: 1
    }
}
