package Greedy;

import java.util.List;

public class o624_Maximum_Distance_in_Arrays {
   public static int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int ans = 0;

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            ans = Math.max(ans, Math.abs(array.get(0) - max));
            ans = Math.max(ans, Math.abs(array.get(array.size() - 1) - min));
            min = Math.min(min, array.get(0));
            max = Math.max(max, array.get(array.size() - 1));
        }

        return ans;
    }
}
