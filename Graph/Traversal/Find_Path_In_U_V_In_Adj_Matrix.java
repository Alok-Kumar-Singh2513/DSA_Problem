package Graph.Traversal;

public class Find_Path_In_U_V_In_Adj_Matrix {
  public static boolean pathPresentOrNot(int[][] graph, int u, int v, boolean[] visited) {
    visited[u] = true; 
    for (int i = 0; i < graph.length; i++) {
      if (graph[u][i] == 1 && !visited[i]) { 
       
      }
    }
    
    return false; 
  }
  public static void main(String[] args) {
    int[][] graph = {
        {0, 1, 0, 1},
        {1, 0, 1, 0},
        {0, 1, 0, 1},
        {1, 0, 1, 0}
    };
    int u = 0;
    int v = 2; 
    boolean[] visited = new boolean[graph.length];
    
    System.out.println("Path from " + u + " to " + v + ":");
    if (pathPresentOrNot(graph, u, v, visited)) {
      System.out.println("Path exists.");
    } else {
      System.out.println("No path exists.");
    }
  }

  
}
