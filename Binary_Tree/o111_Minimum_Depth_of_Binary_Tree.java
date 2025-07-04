package Binary_Tree;
import java.util.*;

public class o111_Minimum_Depth_of_Binary_Tree {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return 0;
        queue.add(root);
        int depth=0;
        while(!queue.isEmpty()){
          int size=queue.size();
          depth++;
          for(int i=0;i<size;i++){
              TreeNode curr=queue.poll();
              if(curr.left==null && curr.right==null){
                  return depth;
              }
              if(curr.left!=null){
                  queue.add(curr.left);
              }
              if(curr.right!=null){
                  queue.add(curr.right);
              }
          }
        }
        return depth;
    }
}