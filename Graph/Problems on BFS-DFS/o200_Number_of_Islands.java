// package Graph;
import java.util.LinkedList;
// import java.util.Queue;

public class o200_Number_of_Islands {
   private char[][] grid;
    private int m;
    private int n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    dfs(i, j);
                    ++ans;
                }
            }
        }
        return ans;
    }

    private void dfs(int i, int j) {
        grid[i][j] = '0';
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int k = 0; k < 4; ++k) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                dfs(x, y);
            }
        }
    }

    // BFS approach
    public int numIslandsBFS(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    bfs(i, j);
                    ++ans;
                }
            }
        }
        return ans;
    }

   private void bfs(int i, int j) {
    grid[i][j] = '0';
    LinkedList<int[]> queue = new LinkedList<>();
    queue.add(new int[]{i, j});

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    while (!queue.isEmpty()) {
        int[] cell = queue.poll();
        for (int k = 0; k < 4; ++k) {
            int x = cell[0] + dx[k];
            int y = cell[1] + dy[k];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                grid[x][y] = '0';
                queue.add(new int[]{x, y});
            }
        }
    }
}

}
