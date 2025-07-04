package String;
import java.util.*;
// Description:
// Given two strings s and t, return true if t is an anagram of s, and false otherwise.
// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
public class o242_Valid_Anagram {
   public static boolean isAnagram(String s, String t) {
       int ss = s.length();
       int tt = t.length();
        if (ss != tt) {
            return false; // If lengths differ, they cannot be anagrams
        }
        int[] charCount = new int[26]; // Assuming only lowercase letters a-z
        for (int i = 0; i < ss; i++) {
            charCount[s.charAt(i) - 'a']++; // Increment count for character in s
            charCount[t.charAt(i) - 'a']--; // Decrement count for character in t
        }
        // If all counts are zero, then s and t are anagrams
        for (int count : charCount) {
            if (count != 0) {
                return false; // If any count is not zero, they are not anagrams
            }
        }
        return true; // All counts are zero, so they are anagrams
       
    }
    // By Sorting
       public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false; 
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray); // Sort characters of s
       Arrays.sort(tArray); // Sort characters of t
        return Arrays.equals(sArray, tArray); 
       }
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean result = isAnagram(s, t);
        System.out.println("Is t an anagram of s? " + result); // Output: true

        s = "rat";
        t = "car";
        result = isAnagram(s, t);
        System.out.println("Is t an anagram of s? " + result); // Output: false
    }

}
