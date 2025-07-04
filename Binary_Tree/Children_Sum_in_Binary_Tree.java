package Binary_Tree;

public class Children_Sum_in_Binary_Tree {
  public static class Node  {
    int data;
    Node left, right;

    Node(int data) {
      this.data = data;
      left = right = null;
    }
  }
   public static int isSumProperty(Node root) {
    if (root == null || (root.left == null && root.right == null)) return 1;

    int left = (root.left != null) ? root.left.data : 0;
    int right = (root.right != null) ? root.right.data : 0;

    if (root.data == left + right 
        && isSumProperty(root.left) == 1 
        && isSumProperty(root.right) == 1) {
        return 1;
    } else {
        return 0;
    }
}
}