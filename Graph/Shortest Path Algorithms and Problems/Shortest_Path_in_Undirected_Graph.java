// package Graph.Shortest Path Algorithms and Problems;
import java.util.*;


public class Shortest_Path_in_Undirected_Graph {
   public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        int n=adj.size();
         int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = (int) 1e9;  
        }
        dist[src] = 0; 

        // BFS Implementation
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while (!q.isEmpty()) {
            int node = q.poll(); 
            for (int neighbor : adj.get(node)) {  // Explore all the neighbors
                // If we find a shorter path to the neighbor, update the distance
                if (dist[node] + 1 < dist[neighbor]) {
                    dist[neighbor] = dist[node] + 1;
                    q.add(neighbor);  
                }
            }
        }

        // Replace all unreachable nodes with -1
        for (int i = 0; i < n; i++) {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;  
            }
        }

        return dist;
    }
}
