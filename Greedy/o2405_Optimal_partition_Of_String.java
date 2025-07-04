package Greedy;

import java.util.HashMap;

public class o2405_Optimal_partition_Of_String {
  public static int partitionString(String s) {
    HashMap<Character, Integer> lastSeen = new HashMap<>();
    int count = 0;
    int currSubStringStart = 0;

    for (int i = 0; i < s.length(); i++) {
        char currChar = s.charAt(i);
        // If the current character has been seen before in the current substring,
        // increment the count and update the start of the current substring
        if (lastSeen.containsKey(currChar) && lastSeen.get(currChar) >= currSubStringStart) {
            count++;
            currSubStringStart = i;
        }
        lastSeen.put(currChar, i);
    }

    // Count the last partition
    return count + 1;
}
  public static void main(String[] args) {
    String s = "abacaba";
    System.out.println(partitionString(s)); // Output: 4
    // Explanation: The optimal partitioning is ["ab", "ac", "ab", "a"].
    // Each substring contains unique characters.
  
  }
}
