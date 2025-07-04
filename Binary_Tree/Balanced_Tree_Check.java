
package Binary_Tree;
public class Balanced_Tree_Check {
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
    public static boolean isBalanced(Node root) {
        // code here
          return height(root) != -1;
    }
    private static int height(Node root) {
    if (root == null) {
      return 0;
    }
    int l = height(root.left);
    int r = height(root.right);
    if (l == -1 || r == -1 || Math.abs(l - r) > 1) {
      return -1;
    }
    return 1 + Math.max(l, r);
  }
}
