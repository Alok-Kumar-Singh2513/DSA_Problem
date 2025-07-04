package Graph.Traversal;
import java.util.*;
public class BFS_Adj_Matrix {
  public static void bfs(int[][] graph, int start) {
    int n = graph.length;
    boolean[] visited = new boolean[n];
    Queue<Integer> queue = new LinkedList<>();

    visited[start] = true;
    queue.add(start);

    while (!queue.isEmpty()) {
      int node = queue.poll();
      System.out.print(node + " ");

      for (int i = 0; i < n; i++) {
        if (graph[node][i] == 1 && !visited[i]) {
          visited[i] = true;
          queue.add(i);
        }
      }
    }
  }
  // bfs at adjacency list representation
  public static void bfsAdjList(int[][] graph, int start) {
    List<List<Integer>> adjList = new ArrayList<>();
    for (int i = 0; i < graph.length; i++) {
      adjList.add(new ArrayList<>());
      for(int e[]: graph) {
        adjList.get(e[0]).add(e[1]);
      }
      Queue<Integer> queue = new LinkedList<>();
      boolean[] visited = new boolean[graph.length];
      visited[start] = true;
      queue.add(start);
      while (!queue.isEmpty()) {
        int node = queue.poll();
        System.out.print(node + " ");
        for (int neighbor : adjList.get(node)) {
          if (!visited[neighbor]) {
            visited[neighbor] = true;
            queue.add(neighbor);
          }
        }
      }

    }

  public static void main(String[] args) {
    int[][] graph = {
      {0, 1, 0, 0, 1},
      {1, 0, 1, 0, 0},
      {0, 1, 0, 1, 0},
      {0, 0, 1, 0, 1},
      {1, 0, 0, 1, 0}
    };
    System.out.println("BFS Traversal starting from node 0:");
    bfs(graph, 0);
  }
  
}
