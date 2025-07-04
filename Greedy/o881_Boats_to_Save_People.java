package Greedy;

import java.util.Arrays;

public class o881_Boats_to_Save_People {
  public static int numRescueBoats(int[] people, int limit) {
        int left = 0;
        int right = people.length - 1;
        int boats = 0;
        Arrays.sort(people);
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            boats++;
        }
        return boats;
  }
}
