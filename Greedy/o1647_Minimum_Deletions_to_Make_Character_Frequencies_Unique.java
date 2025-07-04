package Greedy;

import java.util.HashSet;

public class o1647_Minimum_Deletions_to_Make_Character_Frequencies_Unique {
   public int minDeletions(String s) {
        int deletions = 0;
        int[] frequency = new int[26];

        // Step 1: Count frequency of each character
        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }

        // Step 2: Use a set to keep track of used frequencies
        HashSet<Integer> used = new HashSet<>();

        for (int freq : frequency) {
            while (freq > 0 && used.contains(freq)) {
                freq--; // delete one character
                deletions++;
            }
            if (freq > 0) used.add(freq);
        }

        return deletions;
    }
}
