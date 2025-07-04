package Sliding_Window;

import java.util.HashMap;
import java.util.Map;

public class o76_Minimum_Window_Substring {
  public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        // Map to store the frequency of characters in t
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        // Map to track the frequency of characters in the current window
        Map<Character, Integer> windowMap = new HashMap<>();
        int left = 0, right = 0, required = targetMap.size(), formed = 0;
        int[] result = {-1, 0, 0};  // result[0] will store the length of the window

        // Sliding window approach
        while (right < s.length()) {
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            // If the current character's frequency matches the target frequency, increase the formed count
            if (targetMap.containsKey(c) && windowMap.get(c).intValue() == targetMap.get(c).intValue()) {
                formed++;
            }

            // Try to shrink the window from the left if the current window contains all characters in t
            while (left <= right && formed == required) {
                char leftChar = s.charAt(left);

                // Update the result if the current window is smaller
                if (result[0] == -1 || right - left + 1 < result[0]) {
                    result[0] = right - left + 1;
                    result[1] = left;
                    result[2] = right;
                }

                // Remove the left character from the window
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if (targetMap.containsKey(leftChar) && windowMap.get(leftChar).intValue() < targetMap.get(leftChar).intValue()) {
                    formed--;
                }
                left++;
            }

            // Expand the window to the right
            right++;
        }

        // If result[0] is still -1, no valid window was found
        return result[0] == -1 ? "" : s.substring(result[1], result[2] + 1);
    }
}
