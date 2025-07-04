package Greedy;

import java.util.*;

public class o1921_Eliminate_Maximum_Number_of_Monsters {
   public static int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        List<Integer> time = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // Calculate the time each monster takes to reach the city
            time.add((int) Math.ceil((double) dist[i] / speed[i]));
        }

        // Sort monsters by time to reach the city
        Collections.sort(time);

        for (int i = 0; i < n; i++) {
            if (time.get(i) <= i) {
                // Monster reaches before we can eliminate it
                return i;
            }
        }

        return n; // All monsters can be eliminated
    }
}
