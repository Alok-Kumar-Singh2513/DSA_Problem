package Graph.Traversal;
import java.util.*;
import java.util.Scanner;

public  class DFS_ADJ_MATRIX {
  public static void graphPrint(int[][] graph) {
    for (int i = 0; i < graph.length; i++) {
      for (int j = 0; j < graph[i].length; j++) {
        System.out.print(graph[i][j] + " ");
      }
      System.out.println();
    }
  }

   static int[][] adj;

    
    static void addEdge(int x, int y)
    {
        adj[x][y] = 1;
        adj[y][x] = 1;
    }

  public static void main(String[] args) {
  Scanner scanner = new Scanner(System.in);
  System.out.println("Enter number of vertices in the graph:");
    int vertices = scanner.nextInt();
    adj = new int[vertices][vertices];
    System.out.println("Enter number of edges in the graph:");
    int edges = scanner.nextInt();
    System.out.println("Enter the edges (u v) where u and v are vertex indices:");
    for (int i = 0; i < edges; i++) {
      int u = scanner.nextInt();
      int v = scanner.nextInt();
      addEdge(u, v);
    }

    System.out.println("Adjacency Matrix:");
    graphPrint(adj);

// ==========================
    scanner.close();

    boolean[] visited = new boolean[adj.length];
    System.out.println("DFS Traversal:");
    for (int i = 0; i < adj.length; i++) {
      if (!visited[i]) {
        dfs(adj, i, visited);
      }
    } 
  }
// DFS Using Recursion
  public static void dfs(int[][] graph, int node, boolean[] visited) {
    visited[node] = true;
    System.out.println("Visiting node: " + node);
    for (int i = 0; i < graph.length; i++) {
      if (graph[node][i] == 1 && !visited[i]) {
        dfs(graph, i, visited);
      }
    }
  }

  // DFS using stack
  public static void dfsStack(int[][] graph, int start) {
    boolean[] visited = new boolean[graph.length];
    Stack<Integer> stack = new Stack<>();
    stack.push(start);
    while (!stack.isEmpty()) {
      int node = stack.pop();
      if (!visited[node]) {
        visited[node] = true;
        System.out.println("Visiting : " + node);
        for (int i = 0; i < graph.length; i++) {
          if (graph[node][i] == 1 && !visited[i]) {
            stack.push(i);
          }
        }
      }
    }
  }

  // dfs at adjacency list representation
  public static void dfsAdjList(int[][] graph, int start) {
    List<List<Integer>> adjList = new ArrayList<>();
    for (int i = 0; i < graph.length; i++) {
      adjList.add(new ArrayList<>());
      for (int j = 0; j < graph[i].length; j++) {
        if (graph[i][j] == 1) {
          adjList.get(i).add(j);
        }
      }
      boolean[] visited = new boolean[graph.length];
      visited[start] = true;
      Stack<Integer> stack = new Stack<>();
      stack.push(start);
      while (!stack.isEmpty()) {
        int node = stack.pop();
        System.out.println("Visiting : " + node);
        for (int neighbor : adjList.get(node)) {
          if (!visited[neighbor]) {
            visited[neighbor] = true;
            stack.push(neighbor);
          }
        }
      }
    }
    // Using stack for DFS
    boolean[] visited = new boolean[graph.length];
    Stack<Integer> stack = new Stack<>();
    stack.push(start);
    while (!stack.isEmpty()) {
      int node = stack.pop();
      if (!visited[node]) {
        visited[node] = true;
        System.out.println("Visiting : " + node);
        for (int i = 0; i < graph[node].length; i++) {
          if (graph[node][i] == 1 && !visited[i]) {
            stack.push(i);
          }
        }
      }
    }
  }

}
