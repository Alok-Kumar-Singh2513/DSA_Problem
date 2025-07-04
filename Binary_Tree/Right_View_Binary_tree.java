package Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Right_View_Binary_tree {
  public static class Node {
    int data;
    Node left, right;
    Node(int item) {
      data = item;
      left = right = null;
    }
  }
   ArrayList<Integer> rightView(Node root) {
        // add code here.
          ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
        
            int levelSize = queue.size();
            
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
              
                  if (i == levelSize - 1) {
                    result.add(currentNode.data);
                }
               
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
        
        return result;
    }
}
