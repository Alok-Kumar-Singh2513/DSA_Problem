package String;

import java.util.*;


public class o451_Sort_Characters_By_Frequency {
    public static String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        List<Character> chars = new ArrayList<>(frequencyMap.keySet());

        Collections.sort(chars, (a, b) -> {
            int freqA = frequencyMap.get(a);
            int freqB = frequencyMap.get(b);
            if (freqA != freqB) {
                return freqB - freqA;
            }
            return Character.compare(a, b);
        });

        StringBuilder result = new StringBuilder();
        for (char c : chars) {
            int freq = frequencyMap.get(c);
            for (int i = 0; i < freq; i++) {
                result.append(c);
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "tree";
        String result = frequencySort(s);
        System.out.println("Sorted by frequency: " + result);

        s = "cccaaa";
        result = frequencySort(s);
        System.out.println("Sorted by frequency: " + result);

        s = "Aabb";
        result = frequencySort(s);
        System.out.println("Sorted by frequency: " + result);
    }
}