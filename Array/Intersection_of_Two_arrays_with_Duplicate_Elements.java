import java.util.*;

public class Intersection_of_Two_arrays_with_Duplicate_Elements {
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // Count frequencies in array a
        for (int num : a) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Traverse array b and collect matches
        for (int num : b) {
            if (freqMap.containsKey(num) && freqMap.get(num) > 0) {
                result.add(num);
                freqMap.put(num, freqMap.get(num) - 1); // Decrease count
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Intersection_of_Two_arrays_with_Duplicate_Elements obj = new Intersection_of_Two_arrays_with_Duplicate_Elements();
        int[] a = {1, 2, 2, 3};
        int[] b = {2, 2, 3, 3};

        ArrayList<Integer> result = obj.intersectionWithDuplicates(a, b);
        System.out.println("Intersection with duplicates: " + result);  
    }
}
