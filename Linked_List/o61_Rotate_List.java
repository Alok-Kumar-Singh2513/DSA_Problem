package Linked_List;

public class o61_Rotate_List {
  public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
  public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode cur = head;
        int len = 1;
        while(cur.next != null) {
            cur = cur.next;
            len++;
        }
        cur.next = head; // Connect the end of the list to the head to make it circular
        k = k % len; // In case k is greater than the length of the list
        int stepsToNewHead = len - k;
        ListNode newTail = head;
        for(int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next; // The new head will be the next node after the new tail
        newTail.next = null; // Break the circular link to form the new list
        return newHead; // Return the new head of the rotated list
  }
}
