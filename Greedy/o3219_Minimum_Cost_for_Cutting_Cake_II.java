package Greedy;

import java.util.Arrays;

public class o3219_Minimum_Cost_for_Cutting_Cake_II {
 public long minimumCost(int m, int n, int[] horizontalCuts, int[] verticalCuts) {
        
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int horizontalIndex = horizontalCuts.length - 1;
        int verticalIndex = verticalCuts.length - 1;

        long totalCost = 0;
        long horizontalPieces = 1;
        long verticalPieces = 1;

        // Greedy approach: apply the most expensive cut first
        while (horizontalIndex >= 0 && verticalIndex >= 0) {
            if (horizontalCuts[horizontalIndex] > verticalCuts[verticalIndex]) {
                totalCost = totalCost + (horizontalCuts[horizontalIndex] * verticalPieces);
                horizontalPieces++;
                horizontalIndex--;
            } else {
                totalCost = totalCost + (verticalCuts[verticalIndex] * horizontalPieces);
                verticalPieces++;
                verticalIndex--;
            }
        }

        // Remaining horizontal cuts
        while (horizontalIndex >= 0) {
            totalCost = totalCost + (horizontalCuts[horizontalIndex] * verticalPieces);
            horizontalIndex--;
        }

        // Remaining vertical cuts
        while (verticalIndex >= 0) {
            totalCost = totalCost + (verticalCuts[verticalIndex] * horizontalPieces);
            verticalIndex--;
        }

        return totalCost;
    }
}
