public class o236_Lowest_Common_Ancestor_of_Binary_Tree {
    static class TreeNode {
        int data;
        TreeNode left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    public static List<TreeNode> deleteNodes(TreeNode root, List<Integer> toDelete) {
        Set<Integer> deleteSet = new HashSet<>(toDelete);
        List<TreeNode> forest = new ArrayList<>();
        deleteNodesHelper(root, deleteSet, forest);
        if (!deleteSet.contains(root.data)) {
            forest.add(root);
        }
        return forest;
    }
    
    private static TreeNode deleteNodesHelper(TreeNode node, Set<Integer> deleteSet, List<TreeNode> forest) {
        if (node == null) {
            return null;
        }
        node.left = deleteNodesHelper(node.left, deleteSet, forest);
        node.right = deleteNodesHelper(node.right, deleteSet, forest);
        if (deleteSet.contains(node.data)) {
            if (node.left != null) {
                forest.add(node.left);
            }
            if (node.right != null) {
                forest.add(node.right);
            }
            return null; // Delete this node
        }
        return node; // Keep this node
    }


 
}