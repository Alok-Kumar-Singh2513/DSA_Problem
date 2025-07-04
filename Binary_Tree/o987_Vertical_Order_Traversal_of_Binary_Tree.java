package Binary_Tree;

import java.util.*;

public class o987_Vertical_Order_Traversal_of_Binary_Tree {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
      this.left = null;
      this.right = null;
    }
  }
 public static List<List<Integer>> verticalTraversal(TreeNode root) {

    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;

    // Use a list to store (column, row, value)
    List<int[]> nodeList = new ArrayList<>();
    Queue<Tuple> queue = new LinkedList<>();
    queue.offer(new Tuple(root, 0, 0));

    while (!queue.isEmpty()) {
        Tuple tuple = queue.poll();
        TreeNode node = tuple.node;
        int row = tuple.row;
        int col = tuple.col;

        nodeList.add(new int[]{col, row, node.val});

        if (node.left != null) {
            queue.add(new Tuple(node.left, row + 1, col - 1));
        }
        if (node.right != null) {
            queue.add(new Tuple(node.right, row + 1, col + 1));
        }
    }

    // Sort by col, then row, then value
    nodeList.sort((a, b) -> {
        if (a[0] != b[0]) return a[0] - b[0]; // column
        else if (a[1] != b[1]) return a[1] - b[1]; // row
        else return a[2] - b[2]; // value
    });

    // Group by column
    Map<Integer, List<Integer>> columnTable = new TreeMap<>();
    for (int[] triple : nodeList) {
        int col = triple[0], val = triple[2];
        columnTable.computeIfAbsent(col, k -> new ArrayList<>()).add(val);
    }

    result.addAll(columnTable.values());
    return result;
}

// Helper class
static class Tuple {
    TreeNode node;
    int row, col;
    Tuple(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
  }
}
