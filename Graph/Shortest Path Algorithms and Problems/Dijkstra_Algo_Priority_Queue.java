// package Graph.Shortest Path Algorithms and Problems;
import java.util.*;
public class Dijkstra_Algo_Priority_Queue {
  public int [] dijkstra(int V, int[][] edges, int src) {
    // Build graph as adjacency list
    List<List<int[]>> graph = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      graph.add(new ArrayList<>());
    }
    
    for (int[] edge : edges) {
      graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
      graph.get(edge[1]).add(new int[]{edge[0], edge[2]}); // For undirected graph
    }

    // Initialize distances and priority queue
    int[] dist = new int[V];
    boolean[] visited = new boolean[V];
    for (int i = 0; i < V; i++) {
      dist[i] = Integer.MAX_VALUE;
    }
    dist[src] = 0;

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    pq.offer(new int[]{src, 0});

    while (!pq.isEmpty()) {
      int[] current = pq.poll();
      int u = current[0];

      if (visited[u]) continue;
      visited[u] = true;

      for (int[] neighbor : graph.get(u)) {
        int v = neighbor[0];
        int weight = neighbor[1];

        if (!visited[v] && dist[u] + weight < dist[v]) {
          dist[v] = dist[u] + weight;
          pq.offer(new int[]{v, dist[v]});
        }
      }
    }

    return dist;
  }
  
}
