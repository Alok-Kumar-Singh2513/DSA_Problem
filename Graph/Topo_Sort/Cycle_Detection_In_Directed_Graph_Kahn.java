package Graph.Topo_Sort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Cycle_Detection_In_Directed_Graph_Kahn {
  public boolean isCyclic(int V, int[][] edges) {
    List<List<Integer>> g = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      g.add(new ArrayList<>());
    }

   int inDegree[] = new int[V];
    for (int[] e : edges) {
      g.get(e[0]).add(e[1]);
      inDegree[e[1]]++;
    }
    Queue<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < V; i++) {
      if (inDegree[i] == 0) {
        q.add(i);
      }
    } 
    int c = 0;
    while (!q.isEmpty()) {
      int u = q.poll();
      c++;
      for (int v : g.get(u)) {
        if (--inDegree[v] == 0) {
          q.add(v);
        }
      }
    }
    return c != V;
  }
}
