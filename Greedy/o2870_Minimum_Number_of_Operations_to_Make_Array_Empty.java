package Greedy;

import java.util.HashMap;

public class o2870_Minimum_Number_of_Operations_to_Make_Array_Empty {
   public static int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int operations = 0;
        for (int count : map.values()) {
          if(count== 1){
            return -1;
           }
           operations+=Math.ceil((double)count/3);
        }
        return operations;
    }
}
