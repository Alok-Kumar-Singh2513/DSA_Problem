package Graph.Disjoint;

import java.util.ArrayList;

public class Detect_Cycle_using_DSU {
    public static int detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] parent = new int[V];
        int[] rank = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                if (v > u) { // ensure undirected edge is only processed once
                    int pu = findParent(u, parent);
                    int pv = findParent(v, parent);
                    if (pu == pv) return 1; // cycle detected
                    union(u, v, parent, rank);
                }
            }
        }

        return 0; // no cycle
    }

    public static int findParent(int u, int[] parent) {
        if (parent[u] == u) return u;
        return parent[u] = findParent(parent[u], parent); // path compression
    }

    public static void union(int u, int v, int[] parent, int[] rank) {
        int pu = findParent(u, parent);
        int pv = findParent(v, parent);
        if (pu == pv) return;

        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1); 

        adj.get(2).add(0);
        adj.get(0).add(2); 

        adj.get(3).add(4);
        adj.get(4).add(3); 

        int result = detectCycle(V, adj);
        System.out.println(result);
    }
}
