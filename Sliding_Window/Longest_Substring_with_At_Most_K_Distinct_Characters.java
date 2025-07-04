package Sliding_Window;
import java.util.HashMap;
import java.util.Map;
public class Longest_Substring_with_At_Most_K_Distinct_Characters {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if (n == 0 || k == 0) return 0; 

        int maxLength = 0;
        int left = 0; // Left pointer of the sliding window

        // Use a HashMap to store the frequency of characters in the current window
        // Key: character, Value: its count
        Map<Character, Integer> charFrequency = new HashMap<>();

        // Right pointer expands the window
        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);

            // Add the current character to the window or increment its count
            charFrequency.put(currentChar, charFrequency.getOrDefault(currentChar, 0) + 1);

            // If the number of distinct characters in the window exceeds k,
            // we need to shrink the window from the left.
            while (charFrequency.size() > k) {
                char charAtLeft = s.charAt(left);

                // Decrement the count of the character at the left pointer
                charFrequency.put(charAtLeft, charFrequency.get(charAtLeft) - 1);

                // If the count of charAtLeft becomes 0, it means this character
                // is no longer in the window, so remove it from the map
                if (charFrequency.get(charAtLeft) == 0) {
                    charFrequency.remove(charAtLeft);
                }
                left++; // Move the left pointer to shrink the window
            }

            // Update the maximum length found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
      
        System.out.println("Test 1 (eceba, k=2): " + lengthOfLongestSubstringKDistinct("eceba", 2)); // Expected: 3 (ece)
        
    }
}                                                                                                                                                                                                                