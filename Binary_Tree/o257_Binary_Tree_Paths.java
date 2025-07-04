package Binary_Tree;

import java.util.*;

public class o257_Binary_Tree_Paths {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
      this.left = null;
      this.right = null;
    }
  }
  public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        backtrack(root, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(TreeNode node, List<Integer> path, List<String> result) {
        if (node == null) return;

        path.add(node.val);

        if (node.left == null && node.right == null) {
            result.add(buildPath(path));
        } else {
            backtrack(node.left, path, result);
            backtrack(node.right, path, result);
        }

        path.remove(path.size() - 1); // backtrack
    }

    private static String buildPath(List<Integer> path) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i));
            if (i != path.size() - 1) sb.append("->");
        }
        return sb.toString();
    }
}
