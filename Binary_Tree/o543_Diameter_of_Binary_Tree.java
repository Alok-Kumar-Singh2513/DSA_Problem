package Binary_Tree;

public class o543_Diameter_of_Binary_Tree {
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
  private int diameter = 0;
  public int diameterOfBinaryTree(TreeNode root) {
      dfs(root);
      return diameter;
      
  }
  private int dfs(TreeNode node){
    if(node==null)return 0;
    int left=dfs(node.left);
    int right=dfs(node.right);
    diameter=Math.max(diameter,left+right);
    return Math.max(left,right)+1;
  }
  
  public static void main(String[] args) {
    TreeNode leftChild = new TreeNode(2, null, null);
    TreeNode rightChild = new TreeNode(3, null, null);
    TreeNode root = new TreeNode(1, leftChild, rightChild);

    o543_Diameter_of_Binary_Tree solution = new o543_Diameter_of_Binary_Tree();
    int result = solution.diameterOfBinaryTree(root);
    System.out.println(result); 
  }
}
