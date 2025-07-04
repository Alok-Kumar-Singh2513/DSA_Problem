public class o1361_Validate_Binary_Tree_node {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static boolean isValidBinaryTree(Node root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isValid(Node node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.data <= min || node.data >= max) {
            return false;
        }
        return isValid(node.left, min, node.data) && isValid(node.right, node.data, max);
    }
    // psvm
}