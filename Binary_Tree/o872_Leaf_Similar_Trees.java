public class o872_Leaf_Similar_Trees {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder leaves1 = new StringBuilder();
        StringBuilder leaves2 = new StringBuilder();
        collectLeaves(root1, leaves1);
        collectLeaves(root2, leaves2);
        return leaves1.toString().equals(leaves2.toString());
    }

    private void collectLeaves(TreeNode node, StringBuilder leaves) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            leaves.append(node.val).append(",");
            return;
        }
        collectLeaves(node.left, leaves);
        collectLeaves(node.right, leaves);
    }
}