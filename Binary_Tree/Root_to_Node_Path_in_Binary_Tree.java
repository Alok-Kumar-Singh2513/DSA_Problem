package Binary_Tree;

public class Root_to_Node_Path_in_Binary_Tree {
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
  public static String rootToNodePath(Node root, int target) {
    if (root == null) {
      return "";
    }
    if (root.data == target) {
      return String.valueOf(root.data);
    }

    String leftPath = rootToNodePath(root.left, target);
    if (!leftPath.isEmpty()) {
      return root.data + " -> " + leftPath;
    }

    String rightPath = rootToNodePath(root.right, target);
    if (!rightPath.isEmpty()) {
      return root.data + " -> " + rightPath;
    }

    return "";
  }
  
}
