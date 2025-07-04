
package Binary_Tree;

public class Boundary_traversal {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
  public static void printBoundary(TreeNode root) {
    if (root == null) return;
    System.out.print(root.val + " ");
    printLeftBoundary(root.left);
    printLeaves(root.left);
    printLeaves(root.right);
    printRightBoundary(root.right);
  }
  private static void printLeftBoundary(TreeNode node) {
    if (node == null || (node.left == null && node.right == null)) return;
    System.out.print(node.val + " ");
    if (node.left != null) {
      printLeftBoundary(node.left);
    } else {
      printLeftBoundary(node.right);
    }
  }
  private static void printLeaves(TreeNode node) {
    if (node == null) return;
    if (node.left == null && node.right == null) {
      System.out.print(node.val + " ");
      return;
    }
    printLeaves(node.left);
    printLeaves(node.right);
  }
  private static void printRightBoundary(TreeNode node) {
    if (node == null || (node.left == null && node.right == null)) return;
    if (node.right != null) {
      printRightBoundary(node.right);
    } else {
      printRightBoundary(node.left);
    }
    System.out.print(node.val + " ");
  }
}
