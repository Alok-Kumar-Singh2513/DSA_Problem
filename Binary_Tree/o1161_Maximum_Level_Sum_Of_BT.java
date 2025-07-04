public class o1161_Maximum_Level_Sum_Of_BT {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    public int maxLevelSum(TreeNode root) {
        if (root ==null) return 0;

        int maxSum = Integer.MIN_VALUE;
        int level = 0, maxLevel = 0;
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int currentLevelSum = 0;
            level++;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currentLevelSum += node.val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            if (currentLevelSum > maxSum) {
                maxSum = currentLevelSum;
                maxLevel = level;
            }
        }

        return maxLevel;
    }
}