package Binary_Tree;

public class o104_Maximum_Depth_of_Binary_Tree {
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
  public static int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }

  public static void main(String[] args) {
    TreeNode leftChild = new TreeNode(2, null, null);
    TreeNode rightChild = new TreeNode(3, null, null);
    TreeNode root = new TreeNode(1, leftChild, rightChild);

    int result = maxDepth(root);
    System.out.println(result); // Output: 2
  }
}
