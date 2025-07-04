package Binary_Tree;
public class o100_Same_Tree_ {
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

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode leftChild = new TreeNode(2, null, null);
        TreeNode rightChild = new TreeNode(3, null, null);
        TreeNode root1 = new TreeNode(1, leftChild, rightChild);
        TreeNode root2 = new TreeNode(1, leftChild, rightChild);

        boolean result = isSameTree(root1, root2);
        System.out.println(result); // Output: true
    }
}