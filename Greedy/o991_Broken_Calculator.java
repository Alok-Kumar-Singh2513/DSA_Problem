package Greedy;

public class o991_Broken_Calculator {
  // By greedy
  public static int brokenCalc(int startValue, int target) {
    if (startValue >= target) {
      return startValue - target;
    }

    if (target % 2 == 0) {
      return 1 + brokenCalc(startValue, target / 2);
    } else {
      return 1 + brokenCalc(startValue, target + 1); 
    }

  }

  public static void main(String[] args) {

    int startValue = 2;
    int target = 3;
    System.out.println("Minimum number of operations: " + brokenCalc(startValue, target));

  }
}
