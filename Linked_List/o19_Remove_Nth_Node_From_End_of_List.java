package Linked_List;

public class o19_Remove_Nth_Node_From_End_of_List {
  public static class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}
  public static int getLengthOfLinkedList(ListNode head) {
    int length = 0;
    ListNode current = head;
    while (current != null) {
        length++;
        current = current.next;
    }
    return length;
}

public static ListNode removeNthFromEnd(ListNode head, int n) {
    int length = getLengthOfLinkedList(head);

    if (n == length) {
        return head.next; 
    }

    int target = length - n;
    ListNode current = head;

    // Traverse the list to the node just before the target node
    for (int i = 0; i < target - 1; i++) {
        current = current.next;
    }

    // Remove the nth node from the end
    current.next = current.next.next;

    return head;
}
// by the pointer slow and fast
public static ListNode removeNthFromEndUsingTwoPointers(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode slow = dummy;
    ListNode fast = dummy;

    // Move fast pointer n+1 steps ahead
    for (int i = 0; i <= n; i++) {
        fast = fast.next;
    }

    // Move both pointers until fast reaches the end
    while (fast != null) {
        slow = slow.next;
        fast = fast.next;
    }

    // Remove the nth node from the end
    slow.next = slow.next.next;

    return dummy.next; // Return the modified list
}

}
