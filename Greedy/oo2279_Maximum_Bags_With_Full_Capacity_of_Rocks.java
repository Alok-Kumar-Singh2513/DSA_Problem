package Greedy;
import java.util.*;
public class oo2279_Maximum_Bags_With_Full_Capacity_of_Rocks {
  public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        
    int n=capacity.length;
    int remainingCapacity[] = new int[n];
    for (int i = 0; i < n; i++) {
      remainingCapacity[i] = capacity[i] - rocks[i];
    }
    // Sort the remaining capacities in ascending order
   Arrays.sort(remainingCapacity);
   int fullBags = 0;
   for (int i = 0; i < n; i++) {
      if (remainingCapacity[i] == 0) {
        fullBags++;
      } else if (additionalRocks >= remainingCapacity[i]) {
        additionalRocks -= remainingCapacity[i];
        fullBags++;
      } else {
        break; // No more additional rocks can fill any more bags
      }
    }
    return fullBags;
  }
  public static void main(String[] args) {
    int[] capacity = {2, 3, 4, 5};
    int[] rocks = {1, 2, 3, 4};
    int additionalRocks = 2;
    int result = maximumBags(capacity, rocks, additionalRocks);
    System.out.println("Maximum number of bags with full capacity: " + result); // Output: 3
  }
}
