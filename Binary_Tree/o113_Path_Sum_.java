public class o113_Path_Sum_ {
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        findPaths(root, sum, new ArrayList<>(), result);
        return result;
       
    }
    private static void findPaths(TreeNode node, int sum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        currentPath.add(node.data);
        if (node.left == null && node.right == null && node.data == sum) {
            result.add(new ArrayList<>(currentPath));
        } else {
            findPaths(node.left, sum - node.data, currentPath, result);
            findPaths(node.right, sum - node.data, currentPath, result);
        }
        currentPath.remove(currentPath.size() - 1);
    }
}