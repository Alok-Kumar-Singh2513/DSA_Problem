package Linked_List;

public class Search_an_element_in_the_LL {
  public static class Node{
    int data;
    Node next;
    public Node(int data){
      this.data=data;
      this.next=null;
    }
  }
  public static boolean search(Node head, int target) {
    Node current = head;
    while (current != null) {
      if (current.data == target) {
        return true; 
      }
      current = current.next;
    }
    return false; 
  }
}
