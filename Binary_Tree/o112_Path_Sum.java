package Binary_Tree;
public class o112_Path_Sum {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static boolean hasPathSum(Node root, int sum) {
        if (root == null) {
            return sum == 0;
        }
        sum -= root.data;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}