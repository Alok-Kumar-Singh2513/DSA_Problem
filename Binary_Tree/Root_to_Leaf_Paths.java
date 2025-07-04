package Binary_Tree;

import java.util.ArrayList;

public class Root_to_Leaf_Paths {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      left = null;
      right = null;
    }
  }
  public static ArrayList<ArrayList<Integer>> Paths(Node root) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    ArrayList<Integer> path = new ArrayList<>();
    findPaths(root, path, result);
    return result;
  }
  private static void findPaths(Node node, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
    if (node == null) {
      return;
    }
    
    path.add(node.data);
    
    if (node.left == null && node.right == null) {
      result.add(new ArrayList<>(path));
    } else {
      findPaths(node.left, path, result);
      findPaths(node.right, path, result);
    }
    
    path.remove(path.size() - 1); // backtrack
  } 
  
}
