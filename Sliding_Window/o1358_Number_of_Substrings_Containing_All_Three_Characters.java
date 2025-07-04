package Sliding_Window;

import java.util.Arrays;

public class o1358_Number_of_Substrings_Containing_All_Three_Characters {
  public  static int numberOfSubstrings(String s) {
        int[] lastSeen = new int[3];
        Arrays.fill(lastSeen, -1);  
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            // Update the last seen index of the character
            lastSeen[s.charAt(i) - 'a'] = i;

            // Check if all characters 'a', 'b', and 'c' have been seen at least once
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                // The number of valid substrings ending at the current index i
                // is determined by the smallest index among the three characters.
                int minIndex =1+ Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
                count += (minIndex ); 
            }
        }

        return count;
    }
    public static void main(String[] args) {
        String s = "abcabc";
        int result = numberOfSubstrings(s);
        System.out.println("Number of substrings containing all three characters: " + result); // Expected: 10
    }
}
