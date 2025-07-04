public class o1372_Longest_Zigzag_Path_In_BT {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    private int maxZigzagLength = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        zigzag(root.left, 1, true); // Start with left child
        zigzag(root.right, 1, false); // Start with right child
        return maxZigzagLength;
    }

    private void zigzag(TreeNode node, int length, boolean isLeft) {
        if (node == null) return;
        maxZigzagLength = Math.max(maxZigzagLength, length);
        if (isLeft) {
            zigzag(node.left, 1, true); // Reset length for left child
            zigzag(node.right, length + 1, false); // Increment length for right child
        } else {
            zigzag(node.right, 1, false); // Reset length for right child
            zigzag(node.left, length + 1, true); // Increment length for left child
        }
    }
}