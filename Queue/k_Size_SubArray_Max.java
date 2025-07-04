import java.util.ArrayList;
import java.util.PriorityQueue;

public class k_Size_SubArray_Max {
  static class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    static ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.value - a.value);

        for (int i = 0; i < arr.length; i++) {
            pq.add(new Pair(arr[i], i));

            // Remove elements that are outside the current window
            while (pq.peek().index <= i - k) {
                pq.poll();
            }

            // From i = k - 1 onwards, we have valid windows
            if (i >= k - 1) {
                ans.add(pq.peek().value);
            }
        }

        return ans;
    }
}
