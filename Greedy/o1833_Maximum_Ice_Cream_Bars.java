package Greedy;

import java.util.Arrays;

public class o1833_Maximum_Ice_Cream_Bars {
  public static int maxIceCream(int[] costs, int coins) {
    Arrays.sort(costs);
    int count = 0;
    for (int nums : costs) {
      if (nums > coins) {
        return count;
      } else {
        coins -= nums;
        count++;
      }
    }
    return count;
  }

  // kitna ice cream buy kar sakte ho
  // coins se kam ya barabar ho
  public static void main(String[] args) {
    int[] costs = { 1, 3, 2, 4, 1 };
    int coins = 7;
    System.out.println(maxIceCream(costs, coins));

  }
}
