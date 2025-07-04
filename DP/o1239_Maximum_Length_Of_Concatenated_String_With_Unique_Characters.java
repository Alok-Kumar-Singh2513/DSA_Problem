// package DP;

import java.util.List;

public class o1239_Maximum_Length_Of_Concatenated_String_With_Unique_Characters {

  public static int maxLength(List<String> arr) {
    String temp = "";
    int arrSize = arr.size();
    return backtrack(arr, 0, temp, arrSize);
  }

  // Backtracking function with clear include/exclude choices
  private static int backtrack(List<String> arr, int index, String current, int arrSize) {
    if (index == arr.size()) {
      return current.length();
    }

    int include = 0;
    int exclude = 0;

    if (isUnique(arr.get(index),current)) { // Check if the current string can be included
      exclude = backtrack(arr, index + 1, current , arrSize);
    }else {
      exclude = backtrack(arr, index + 1, current, arrSize); 
      include = backtrack(arr, index + 1, current + arr.get(index), arrSize);
    }

    // Return the max of include or exclude
    return Math.max(include, exclude);
  }

  // Helper function to check if all characters are unique in the string
  private static boolean isUnique(String str1,String str2) {
    int [] charCount = new int[26];
    for (char c : str1.toCharArray()) {
      charCount[c - 'a']++;
      if (charCount[c - 'a'] > 0) {
        return false;
      }
    }
    for (char c : str2.toCharArray()) {
      charCount[c - 'a']++;
      if (charCount[c - 'a'] > 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    List<String> arr = List.of("un", "iq", "ue");
    System.out.println("Maximum length: " + maxLength(arr)); 

    arr = List.of("cha", "r", "act", "ers");
    System.out.println("Maximum length: " + maxLength(arr)); 

    arr = List.of("abcdefghijklmnopqrstuvwxyz");
    System.out.println("Maximum length: " + maxLength(arr)); 
  }
}
