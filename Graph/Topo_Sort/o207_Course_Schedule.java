package Graph.Topo_Sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class o207_Course_Schedule {
  public boolean canFinish(int V, int[][] prerequisites) {
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
          int indegree[] = new int[V];
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
           for(int e[]: prerequisites) {
                adj.get(e[1]).add(e[0]);
                indegree[e[0]]++;
            }
        
            Queue<Integer> q = new LinkedList<Integer>();
            for (int i = 0; i < V; i++) {
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
            
            List<Integer> topo = new ArrayList<Integer>();
        
           while (!q.isEmpty()) {
                int u = q.poll();
                topo.add(u);
                for (int v : adj.get(u)) {
                    if (--indegree[v] == 0) {
                        q.add(v);
                    }
                }
            }
            if (topo.size() == V) return true;
            return false;
    }
}
