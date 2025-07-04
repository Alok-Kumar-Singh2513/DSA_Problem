package Greedy;

import java.util.*;

public class o1481_Least_Number_of_Unique_Integers_after_K_Removals {
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        // Step 1: Count frequencies
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Store frequencies in an array
        int[] counts = new int[map.size()];
        int index = 0;
        for (int count : map.values()) {
            counts[index++] = count;
        }

        // Step 3: Sort the frequency array
        Arrays.sort(counts);

        // Step 4: Greedily remove lowest frequency items
        int uniqueCount = counts.length;
        for (int i = 0; i < counts.length; i++) {
            if (k >= counts[i]) {
                k -= counts[i];
                uniqueCount--;
            } else {
                break;
            }
        }

        return uniqueCount;
    }
}
