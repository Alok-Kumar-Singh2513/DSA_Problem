package Greedy;
import java.util.Arrays;
public class o3218_Minimum_Cost_for_Cutting_Cake_I {
  public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        int MOD = 1_000_000_007;

        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);

        int i = horizontalCut.length - 1;
        int j = verticalCut.length - 1;

        long totalCost = 0;
        long horizontalPieces = 1;
        long verticalPieces = 1;

        // Process cuts in descending order of cost
        while (i >= 0 && j >= 0) {
            if (horizontalCut[i] > verticalCut[j]) {
                totalCost = (totalCost + (horizontalCut[i] * verticalPieces) % MOD) % MOD;
                horizontalPieces++;
                i--;
            } else {
                totalCost = (totalCost + (verticalCut[j] * horizontalPieces) % MOD) % MOD;
                verticalPieces++;
                j--;
            }
        }

        while (i >= 0) {
            totalCost = (totalCost + (horizontalCut[i] * verticalPieces) % MOD) % MOD;
            i--;
        }

        while (j >= 0) {
            totalCost = (totalCost + (verticalCut[j] * horizontalPieces) % MOD) % MOD;
            j--;
        }

        return (int) totalCost;
    }
}
