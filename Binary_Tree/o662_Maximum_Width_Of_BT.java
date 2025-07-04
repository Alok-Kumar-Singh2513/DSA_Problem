package Binary_Tree;
import java.util.*;
public class o662_Maximum_Width_Of_BT {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, 0, 0, new HashMap<>());
    }

    private int dfs(TreeNode node, int depth, int index, Map<Integer, Integer> leftmost) {
        if (node == null) return 0;

        leftmost.putIfAbsent(depth, index);
        int width = index - leftmost.get(depth) + 1;

        int leftWidth = dfs(node.left, depth + 1, index * 2, leftmost);
        int rightWidth = dfs(node.right, depth + 1, index * 2 + 1, leftmost);

        return Math.max(width, Math.max(leftWidth, rightWidth));
    }
}