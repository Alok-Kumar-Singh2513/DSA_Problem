package MTE;

import java.util.HashMap;

public class o3_LongestSubstring_Without_Repeating_Characters {
  public static int lengthOfLongestSubstring(String s) {
        int n = s.length(); 
        HashMap<Character, Integer> map = new HashMap<>();  
        int left = 0;  
        int maxLength = 0;  

        for (int right = 0; right < n; right++) {  
            char currentChar = s.charAt(right);
            // If the character is already in the map and its index is >= left, move the left pointer
            if (map.containsKey(currentChar) && map.get(currentChar) >= left) {
                left = map.get(currentChar) + 1;  // Move the left pointer to avoid duplicates
            }

            // Update the map with the new position of the current character
            map.put(currentChar, right);

            // Calculate the length of the current substring and update the maxLength
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;  
    }
}
