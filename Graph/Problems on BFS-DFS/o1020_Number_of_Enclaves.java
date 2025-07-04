// package Graph.Problems on BFS-DFS;
import java.util.LinkedList;
import java.util.Queue;

public class o1020_Number_of_Enclaves {
   public static int numEnclaves(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();  // Change to store int arrays (row, col)
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];

        // Traverse boundary elements
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // First row, first column, last row, last column
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    // If it is land (1), store it in the queue
                    if (grid[i][j] == 1) {
                        q.add(new int[] {i, j});  // Use int array to store coordinates
                        vis[i][j] = 1;
                    }
                }
            }
        }

        // Directions for top, right, bottom, left
        int[] delrow = {-1, 0, +1, 0};
        int[] delcol = {0, 1, 0, -1};

        // Perform BFS to mark all connected land to the boundary as visited
        while (!q.isEmpty()) {
            int[] curr = q.peek();  // Get the current coordinates (row, col)
            int row = curr[0];
            int col = curr[1];
            q.remove();

            // Traverse all 4 directions
            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                // Check for valid coordinates and unvisited land cell
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                        && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    q.add(new int[] {nrow, ncol});  // Add the new coordinates to the queue
                    vis[nrow][ncol] = 1;
                }
            }
        }

        // Count remaining land cells (enclaves) that are not connected to the boundary
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If it is unvisited land cell
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
