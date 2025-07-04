package Binary_Tree;
public class o623_Add_One_Row_to_Tree {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        addRow(root, val, depth - 1);
        return root;
    }

    private static void addRow(TreeNode node, int val, int depth) {
        if (node == null) return;
        if (depth == 1) {
            TreeNode newLeft = new TreeNode(val);
            TreeNode newRight = new TreeNode(val);
            newLeft.left = node.left;
            newRight.right = node.right;
            node.left = newLeft;
            node.right = newRight;
        } else {
            addRow(node.left, val, depth - 1);
            addRow(node.right, val, depth - 1);
        }
    }
}