
import java.util.*;
public class Shortest_path_in_Directed_Acyclic_Graph {
   static class Pair {
        int first, second;
        Pair(int _first, int _second) {
            this.first = _first;
            this.second = _second;
        }
    }

    private static void topoSort(int node, ArrayList<ArrayList<Pair>> adj, int[] vis, Stack<Integer> st) {
        vis[node] = 1;
        for (int i = 0; i < adj.get(node).size(); i++) {
            int v = adj.get(node).get(i).first;
            if (vis[v] == 0) {
                topoSort(v, adj, vis, st);
            }
        }
        st.push(node);
    }

    // Main function to find the shortest path in a Directed Acyclic Graph
    public static int[] shortestPath(int V, int E, int[][] edges) {
        // Step 1: Create the adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Populate the adjacency list with edges
        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }

        // Step 3: Initialize visited array and stack for Topological Sort
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();

        // Step 4: Perform Topological Sort on the graph
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                topoSort(i, adj, vis, st);
            }
        }

        // Step 5: Initialize the distance array with a large value
        int[] dist = new int[V];
        Arrays.fill(dist, (int)(1e9));
        dist[0] = 0;  // Distance to the source node is 0

        // Step 6: Process the nodes in reverse topological order
        while (!st.isEmpty()) {
            int node = st.pop();  // Get the node from the stack

            for (int i = 0; i < adj.get(node).size(); i++) {
                int v = adj.get(node).get(i).first;
                int wt = adj.get(node).get(i).second;

                // Step 7: Relax the edges
                if (dist[node] + wt < dist[v]) {
                    dist[v] = dist[node] + wt;
                }
            }
        }

        // Step 8: Mark all unreachable nodes as -1
        for (int i = 0; i < V; i++) {
            if (dist[i] == (int)(1e9)) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}
