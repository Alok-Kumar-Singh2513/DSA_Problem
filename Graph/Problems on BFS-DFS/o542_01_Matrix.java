// package Graph.Problems on BFS-DFS;
import java.util.*;

public class o542_01_Matrix {
   public static int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();

        int nrow[]= {-1, 0, 1, 0};
        int ncol[]= {0, 1, 0, -1};

        // Initialize the answer matrix and add all '0' cells to the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                    queue.add(new int[]{i, j});
                } else {
                    ans[i][j] = Integer.MAX_VALUE; // Set distance for '1' cells to infinity
                }
            }
        }

        // Perform BFS
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            // Explore all four neighbors using the directions array
            for (int k = 0; k < 4; k++) {
                int newRow = row + nrow[k];
                int newCol = col + ncol[k];
                // Check if the new position is within bounds
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                    // If the new cell can be updated with a smaller distance
                    if (ans[newRow][newCol] > ans[row][col] + 1) {
                        ans[newRow][newCol] = ans[row][col] + 1;
                        queue.add(new int[]{newRow, newCol});
                    }
                }
            }
        }     

        return ans;
    }
}
                      
