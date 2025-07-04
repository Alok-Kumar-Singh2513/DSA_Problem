package Linked_List;

public class o2095_Delete_the_Middle_Node_of_a_Linked_List {
  public static class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}
  public static ListNode deleteMiddle(ListNode head) {
    // Edge case: if the list is empty or has only one node
    if (head == null || head.next == null) {
        return null; 
    }
    ListNode slow = head; 
    ListNode fast = head; 
    ListNode prev = null; 

    // Use two pointers to find the middle node
    while (fast != null && fast.next != null) {
        prev = slow;           
        slow = slow.next;     
        fast = fast.next.next; 
    }

    // At this point, 'slow' is the middle node to be deleted
    // 'prev' is the node before slow
    if (prev != null) {
        prev.next = slow.next; // Bypass the middle node
    }

    return head; 
}
}
