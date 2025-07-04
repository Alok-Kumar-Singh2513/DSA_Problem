package Sliding_Window;

import java.util.HashMap;
import java.util.Map;

public class o424_Longest_Repeating_Character_Replacement {
    public static int characterReplacement(String s, int k) {
        int left = 0; 
        int maxLength = 0; 
        int maxFrequency = 0; 

        Map<Character, Integer> charCount = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            charCount.put(currentChar, charCount.getOrDefault(currentChar, 0) + 1);

            maxFrequency = Math.max(maxFrequency, charCount.get(currentChar));

            // calculate the number of characters that need to be replaced
            // current length of the window is (right - left + 1)- maxFrequency
            int charactersToReplace = (right - left + 1) - maxFrequency;

            // Shrink window if replacements needed exceed k
            while (charactersToReplace > k) {
                char charAtLeft = s.charAt(left);
                charCount.put(charAtLeft, charCount.get(charAtLeft) - 1); 
                left++; 

                // Recalculate characters to replace for the new window size
                charactersToReplace = (right - left + 1) - maxFrequency; 
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Test 1 (ABAB, 2): " + characterReplacement("ABAB", 2));       // Expected: 4
        System.out.println("Test 2 (AABABBA, 1): " + characterReplacement("AABABBA", 1)); // Expected: 4
        System.out.println("Test 3 (ABAA, 0): " + characterReplacement("ABAA", 0));       // Expected: 2 (AA)
        System.out.println("Test 4 (AABBC, 1): " + characterReplacement("AABBC", 1));     // Expected: 3 (AAA or BBB)
        System.out.println("Test 5 (AAAA, 2): " + characterReplacement("AAAA", 2));       // Expected: 4
        System.out.println("Test 6 (AAAB, 0): " + characterReplacement("AAAB", 0));       // Expected: 3
    }
}