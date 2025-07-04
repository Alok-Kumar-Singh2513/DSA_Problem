package Binary_Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class o102_Binary_Tree_Level_Order_Traversal {
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

  public static List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) {
      return ans;
    }
    Deque<TreeNode> q = new ArrayDeque<>();
    q.offer(root);
    while (!q.isEmpty()) {
      List<Integer> t = new ArrayList<>();
      for (int n = q.size(); n > 0; --n) {
        TreeNode node = q.poll();
        t.add(node.val);
        if (node.left != null) {
          q.add(node.left);
        }
        if (node.right != null) {
          q.add(node.right);
        }
      }
      ans.add(t);
    }
    return ans;
  }

  public static void printLevelOrder(TreeNode root) {
    List<List<Integer>> result = levelOrder(root);
    for (List<Integer> level : result) {
      System.out.println(level);
    }
  }

  public static void main(String[] args) {
    TreeNode leftChild = new TreeNode(2, null, null);
    TreeNode rightChild = new TreeNode(3, null, null);
    TreeNode root = new TreeNode(1, leftChild, rightChild);

    List<List<Integer>> result = levelOrder(root);
    System.out.println(result); // Output: [[1], [2, 3]]
  }

}
