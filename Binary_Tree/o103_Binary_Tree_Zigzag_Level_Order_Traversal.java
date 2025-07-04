package Binary_Tree;

import java.util.*;

public class o103_Binary_Tree_Zigzag_Level_Order_Traversal {
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
  
  public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    ArrayList<List<Integer>> ans=new ArrayList<>();
    Deque<TreeNode> q=new ArrayDeque<>();
    if(root==null)return ans;
    boolean leftToRight=true;
    q.add(root);
    while(!q.isEmpty()){
      List<Integer> t=new ArrayList<>();
      for(int i=0;i<q.size();i++){
        TreeNode node=q.poll();
        t.add(node.val);
        if(node.left!=null)q.add(node.left);
        if(node.right!=null)q.add(node.right);
      }
      if(!leftToRight){
        Collections.reverse(t);
      }
      ans.add(t);
      leftToRight=!leftToRight;
    }
    return ans;

   }

  public static void main(String[] args) {
    TreeNode leftChild = new TreeNode(2, null, null);
    TreeNode rightChild = new TreeNode(3, null, null);
    TreeNode root = new TreeNode(1, leftChild, rightChild);
    List<List<Integer>> result = zigzagLevelOrder(root);
    System.out.println(result); 
}
}