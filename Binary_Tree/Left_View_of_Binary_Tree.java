package Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Left_View_of_Binary_Tree {
  public static class Node{
    int data;
    Node left, right;

    Node(int item) {
      data = item;
      left = right = null;
    }
  }
  public ArrayList<Integer> leftView(Node root) {
    if(root==null){
      return new ArrayList<>();
    }
    ArrayList<Integer>ans= new ArrayList<>();
     Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
          int levelSize=queue.size();
          for(int i=0;i<levelSize;i++){
            Node currentNode= queue.poll();
            if(i==0){
              ans.add(currentNode.data);
            }
            if(currentNode.left!=null){
              queue.add(currentNode.left);
            }
            if(currentNode.right!=null){
              queue.add(currentNode.right);
            }
          }
        }
        return ans;
  }
}
