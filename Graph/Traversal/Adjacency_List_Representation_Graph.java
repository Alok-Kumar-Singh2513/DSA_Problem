package Graph.Traversal;
import java.util.*;
public class Adjacency_List_Representation_Graph {
  public static void main(String[] args) {
    int n=5;
    List<List<Integer>> graph=new  ArrayList<>();
    for(int i=0;i<n;i++){
      graph.add(new ArrayList<>());
    }
    // creating the graph method
    addEdge(graph, 0, 1);
  }

  public static void addEdge(List<List<Integer>> graph, int u, int v) {
    graph.get(u).add(v);
    graph.get(v).add(u);
  }
  


}
