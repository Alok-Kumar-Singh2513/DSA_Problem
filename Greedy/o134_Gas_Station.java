package Greedy;

public class o134_Gas_Station {
   public static int canCompleteCircuit(int[] gas, int[] cost) {
      int totalGas = 0, totalCost = 0, currentGas = 0, startIndex = 0;

      for (int i = 0; i < gas.length; i++) {
         totalGas += gas[i];
         totalCost += cost[i];
         currentGas += gas[i] - cost[i];

         // If current gas is negative, reset the start index
         if (currentGas < 0) {
            startIndex = i + 1;
            currentGas = 0;
         }
      }

      // If total gas is less than total cost, return -1
      return (totalGas < totalCost) ? -1 : startIndex;
        
    }
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int result = canCompleteCircuit(gas, cost);
        System.out.println("Starting index to complete the circuit: " + result); // Output: 3
    }
}
