package Binary_Tree;
import java.util.*;
public class o863_All_Nodes_Distance_K_in_Binary_Tree {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, parentMap);
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(target);
        visited.add(target);
        
        while (k-- > 0 && !queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left != null && !visited.contains(current.left)) {
                    visited.add(current.left);
                    queue.offer(current.left);
                }
                if (current.right != null && !visited.contains(current.right)) {
                    visited.add(current.right);
                    queue.offer(current.right);
                }
                if (parentMap.get(current) != null && !visited.contains(parentMap.get(current))) {
                    visited.add(parentMap.get(current));
                    queue.offer(parentMap.get(current));
                }
            }
        }
        
        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }
        
        return result;
    }

    private void buildParentMap(TreeNode node, Map<TreeNode, TreeNode> parentMap) {
        if (node == null) return;
        if (node.left != null) {
            parentMap.put(node.left, node);
            buildParentMap(node.left, parentMap);
        }
        if (node.right != null) {
            parentMap.put(node.right, node);
            buildParentMap(node.right, parentMap);
        }
    }
}