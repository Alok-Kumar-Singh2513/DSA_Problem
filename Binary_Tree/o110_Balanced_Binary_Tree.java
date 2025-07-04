package Binary_Tree;

public class o110_Balanced_Binary_Tree {
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

  public static boolean isBalanced(TreeNode root) {
    return height(root) != -1;
  }

  private static int height(TreeNode root) {
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

  public static void main(String[] args) {
    TreeNode leftChild = new TreeNode(2, null, null);
    TreeNode rightChild = new TreeNode(3, null, null);
    TreeNode root = new TreeNode(1, leftChild, rightChild);

    boolean result = isBalanced(root);
    System.out.println(result);
  }
}
