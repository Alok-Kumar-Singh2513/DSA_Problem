package Greedy;
// import java.util.Arrays;
public class o1007_Minimum_Domino_Rotations_For_Equal_Row {
    public static int minDominoRotations(int[] tops, int[] bottoms) {
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; i++) {
            int step = findStep(tops, bottoms, i);
            if (step != -1) {
                ans = Math.min(ans, step);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static int findStep(int[] tops, int[] bottoms, int target) {
        int swapTop = 0;
        int swapBottom = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != target && bottoms[i] != target) {
                return -1;
            }
            if (tops[i] != target) swapTop++;
            if (bottoms[i] != target) swapBottom++;
        }
        return Math.min(swapTop, swapBottom);
    }
}
