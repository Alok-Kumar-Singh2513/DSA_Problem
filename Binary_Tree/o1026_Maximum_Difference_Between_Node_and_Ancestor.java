public class o1026_Maximum_Difference_Between_Node_and_Ancestor {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public int maxAncestorDiff(TreeNode root) {
        return maxDiffHelper(root, root.val, root.val);
    }

    private int maxDiffHelper(TreeNode node, int minVal, int maxVal) {
        if (node == null) return maxVal - minVal;

        minVal = Math.min(minVal, node.val);
        maxVal = Math.max(maxVal, node.val);

        int leftDiff = maxDiffHelper(node.left, minVal, maxVal);
        int rightDiff = maxDiffHelper(node.right, minVal, maxVal);

        return Math.max(leftDiff, rightDiff);
    }
}