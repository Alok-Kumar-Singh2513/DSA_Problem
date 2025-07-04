package Graph;

public class Main {
   static int H, W;
    static char[][] grid;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static int longestABCPath(char[][] inputGrid, int h, int w) {
        H = h;
        W = w;
        grid = inputGrid;
        int maxPath = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (grid[i][j] == 'A') {
                    maxPath = Math.max(maxPath, dfs(i, j, 'A'));
                }
            }
        }

        return maxPath;
    }

    private static int dfs(int i, int j, char expected) {
        if (i < 0 || i >= H || j < 0 || j >= W || grid[i][j] != expected) {
            return 0;
        }

        int maxLen = 0;
        for (int d = 0; d < 8; d++) {
            int ni = i + dx[d];
            int nj = j + dy[d];
            maxLen = Math.max(maxLen, dfs(ni, nj, (char)(grid[i][j] + 1)));
        }

        return maxLen; 
    }
    public static void main(String[] args) {
      // Input in BufferedReader or Scanner format
      char[][] inputGrid = {
          {'A', 'B', 'E'},
          {'C', 'F', 'G'},
          {'A', 'B', 'C'}
      };
      int h = inputGrid.length;
      int w = inputGrid[0].length;
      int result = longestABCPath(inputGrid, h, w);
      System.out.println();
      System.out.println("Longest ABC Path Length: " + result); // Output: 3
    }
}
