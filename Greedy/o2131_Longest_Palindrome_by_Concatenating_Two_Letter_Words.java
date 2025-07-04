package Greedy;

import java.util.*;


public class o2131_Longest_Palindrome_by_Concatenating_Two_Letter_Words {

  // First Method
   public static int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int length = 0;
        boolean hasMiddle = false;

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (String word : map.keySet()) {
            String reversed = new StringBuilder(word).reverse().toString();

            if (!word.equals(reversed)) { // "ab", "ba" => "ab"
                if (map.containsKey(reversed)) {
                    int pairs = Math.min(map.get(word), map.get(reversed));
                    length += pairs * 4;
                    map.put(word, map.get(word) - pairs);
                    map.put(reversed, map.get(reversed) - pairs);
                }
            }
        }

        for (String word : map.keySet()) {
            if (word.charAt(0) == word.charAt(1)) {
                int count = map.get(word);
                length += (count / 2) * 4;
                if (count % 2 == 1) hasMiddle = true;
            }
        }

        if (hasMiddle) length += 2;

        return length;
    }

   
  public static void main(String[] args) {
    String[] words = {"lc", "cl", "gg"};
    System.out.println(longestPalindrome(words)); 
   
  }
}
