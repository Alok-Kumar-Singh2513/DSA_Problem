// package Graph;
// import
import java.util.*;
public class o733_Flood_Fill {
  private void dfs(int row, int col, int[][] image, int newColor, int originalColor) {
        image[row][col] = newColor;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if (nrow >= 0 && nrow < image.length && ncol >= 0 && ncol < image[0].length && image[nrow][ncol] == originalColor) {
                dfs(nrow, ncol, image, newColor, originalColor);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor == color) {
            return image;
        }
        dfs(sr, sc, image, color, originalColor);
        return image;
    }
    // by bfs
    public int[][] floodFillBFS(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor == color) {
            return image;
        }

        int rows = image.length;
        int cols = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = color;

        while (!queue.isEmpty()) {
            int[] pixel = queue.poll();
            int row = pixel[0];
            int col = pixel[1];

            // Explore neighbors
            for (int[] dir : new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}) {
                int nrow = row + dir[0];
                int ncol = col + dir[1];
                if (nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols && image[nrow][ncol] == originalColor) {
                    image[nrow][ncol] = color;
                    queue.offer(new int[]{nrow, ncol});
                }
            }
        }
        return image;
    }
}
