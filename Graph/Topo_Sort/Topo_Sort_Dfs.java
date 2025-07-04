package Graph.Topo_Sort;

import java.util.*;

public class Topo_Sort_Dfs {
   public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        boolean visited[]=new boolean[V];
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
        }
      Stack<Integer> stack=new Stack<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(graph, visited, stack, i);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }
        return ans;
    }
    private static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, Stack<Integer> stack, int node) {
          visited[node] = true;
          for(int i=0;i<graph.get(node).size();i++){
              if(!visited[graph.get(node).get(i)]){
                  dfs(graph, visited, stack, graph.get(node).get(i));
              }
          }
          stack.push(node);
      }
  
}
