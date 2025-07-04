package Greedy;

import java.util.HashMap;

public class o2244_Minimum_Rounds_to_Complete_All_Tasks {
  public static int minimumRounds(int[] tasks) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int task : tasks) {
      map.put(task, map.getOrDefault(task, 0) + 1);
    }
    int rounds = 0;
    for (int count : map.values()) {
      if (count == 1) {
        return -1; // impossible to complete this task
      }else if (count % 3 == 0) {
        // if count is divisible by 3, we can complete it in count/3 rounds
        rounds += count / 3;
      } else {
        // if count is not divisible by 3, we can complete it in count/3 + 1 rounds
        // because we can take 2 tasks in the last round
        rounds += count / 3 + 1;
      }
    } 
    return rounds;

  }
  public static void main(String[] args) {
    int[] tasks = { 2, 2, 3, 3, 4, 4, 4 };
    System.out.println(minimumRounds(tasks)); 
  }
}
