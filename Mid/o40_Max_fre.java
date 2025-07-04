import java.util.HashMap;
import java.util.Map;

public class o40_Max_fre{
   public static void findMaxFrequencyElement(int[] arr) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // Step 1: Count frequency
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Find element with max frequency
        int maxFreq = 0;
        int maxElem = arr[0];

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                maxElem = entry.getKey();
            }
        }

        // Output
        System.out.println("Element with max frequency: " + maxElem);
        System.out.println("Frequency: " + maxFreq);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 1, 4, 1, 3, 3, 3};
        findMaxFrequencyElement(arr);
    }
}