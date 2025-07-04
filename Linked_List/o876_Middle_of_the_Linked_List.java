package Linked_List;

public class o876_Middle_of_the_Linked_List {
  public static class ListNode{
    int data;
    ListNode next;
    public ListNode(int data){
      this.data=data;
      this.next=null;
    }
  }
  public static ListNode middleNode(ListNode head) {
    if (head == null) {
        return null;
    }

    ListNode slow = head;  
    ListNode fast = head; 

    // Move fast two steps and slow one step until fast reaches the end
    while (fast != null && fast.next != null) {
        slow = slow.next;        
        fast = fast.next.next;  
    }

    return slow;
}
}
