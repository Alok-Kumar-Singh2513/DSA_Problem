package Linked_List;

public class o237_Delete_Node_in_a_Linked_List {
  public static class ListNode{
    int data;
    ListNode next;
    public ListNode(int data){
      this.data=data;
      this.next=null;
    }
  }
  public static void deleteNode(ListNode node) {
    if (node == null || node.next == null) {
        return; 
    }
    node.data = node.next.data;
    node.next = node.next.next;
}
}
