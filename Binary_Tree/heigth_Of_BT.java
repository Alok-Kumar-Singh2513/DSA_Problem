package Binary_Tree;

public class heigth_Of_BT {
  public class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
      this.data= data;
      left= null;
      right= null;
    } 
  }
  public static int height(Node root){
    if(root== null){
      return -1;
    }
    int leftHeight= height(root.left);
    int rightHeight= height(root.right);
    return Math.max(leftHeight, rightHeight)+1;
  }
}
