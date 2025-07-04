package Binary_Tree;

public class o124_Binary_Tree_Maximum_Path_Sum {
  public static class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
      this.val = val;
      left = right = null;
    }
  }
   
  public int maxPathSum(TreeNode root) {
    maxPathSumDownFrom(root);
    return ans;
  }

  private int ans = Integer.MIN_VALUE;

  private int maxPathSumDownFrom(TreeNode root) {
    if (root == null)
      return 0;

    final int l = Math.max(maxPathSumDownFrom(root.left), 0);
    final int r = Math.max(maxPathSumDownFrom(root.right), 0);
    ans = Math.max(ans, root.val + l + r);
    return root.val + Math.max(l, r);
  }
  
}
