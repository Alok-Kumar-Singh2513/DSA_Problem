package Binary_Tree;
import java.util.*;
public class find_leaves_of_binary_tree {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    public static List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        findLeavesHelper(root, levelMap);
        for (List<Integer> leaves : levelMap.values()) {
            result.add(leaves);
        }
        return result;
    }

    private static int findLeavesHelper(TreeNode node, Map<Integer, List<Integer>> levelMap) {
        if (node == null) {
            return -1;
        }

        int level = 1 + Math.max(findLeavesHelper(node.left, levelMap), findLeavesHelper(node.right, levelMap));

        levelMap.putIfAbsent(level, new ArrayList<>());
        levelMap.get(level).add(node.val);
        return level;
    }
}
