package Graph.Topo_Sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Kahn_Algorithm {
  public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        int[] in = new int[V];
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) g.add(new ArrayList<>());
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            in[e[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) if (in[i] == 0) q.add(i);
        
        while (!q.isEmpty()) {
            int u = q.poll();
            res.add(u);
            for (int v : g.get(u)) if (--in[v] == 0) q.add(v);
        }
        return res;
    }

}
