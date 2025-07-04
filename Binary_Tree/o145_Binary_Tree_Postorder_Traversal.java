package Binary_Tree;

import java.util.ArrayList;
import java.util.List;

public class o145_Binary_Tree_Postorder_Traversal {
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

  public static List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    dfs(root, ans);
    return ans;
  }

  private static void dfs(TreeNode root, List<Integer> ans) {
    if (root == null) {
      return;
    }
    dfs(root.left, ans);
    dfs(root.right, ans);
    ans.add(root.val);
  }

  public static void main(String[] args) {
    TreeNode leftChild = new TreeNode(2, null, null);
    TreeNode rightChild = new TreeNode(3, null, null);
    TreeNode root = new TreeNode(1, leftChild, rightChild);

    List<Integer> result = postorderTraversal(root);
    System.out.println(result);
  }
}
