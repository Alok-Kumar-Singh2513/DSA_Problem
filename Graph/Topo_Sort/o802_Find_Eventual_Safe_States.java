package Graph.Topo_Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// Adding only node which have only one incoming path

public class o802_Find_Eventual_Safe_States {
  public static List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;

        List<List<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjRev.add(new ArrayList<>());
        }
        int[] indegree = new int[V];

        for(int e[] : graph) {
           adjRev.get(e[1]).add(e[0]);  
            indegree[e[0]]++; 
        }

        // Queue to store nodes with no incoming edges (safe nodes initially)
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> safeNodes = new ArrayList<>();

        // Topological sort
        while (!q.isEmpty()) {
            int node = q.poll();  
            safeNodes.add(node); 
            for (int neighbor : adjRev.get(node)) {
                indegree[neighbor]--;  
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);  // Add neighbor if it becomes safe
                }
            }
        }

        // Sort the safe nodes before returning (to meet the problem's requirement)
        Collections.sort(safeNodes);
        return safeNodes;
    }
}
