package Greedy;
import java.util.*;
public class o2554_Maximum_Number_of_Integers_to_Choose_From_Range {
   public int maxCount(int[] banned, int n, int maxSum) {
    Set<Integer> set = new HashSet<>();
    int count=0;
    int sum=0;
    for (int i : banned) {
        set.add(i);
    }
    for (int i = 1; i <= n; i++) {
        if (set.contains(i)) {
            continue;
        }
        if (sum + i > maxSum) {
            break;
        }
        sum += i;
        count++;
    }
    return count;
    }

   
}
