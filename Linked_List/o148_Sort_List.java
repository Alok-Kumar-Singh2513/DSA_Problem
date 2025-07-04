package Linked_List;

public class o148_Sort_List {
  public static class ListNode {
    int data;
    ListNode next;
    ListNode(int x) { data = x; }
  }
  public static ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
        return head;  // Base case: empty or single-node list
    }

    // Step 1: Split the list into halves
    ListNode mid = findMiddle(head);
    ListNode left = head;
    ListNode right = mid.next;
    mid.next = null;  // Split the list into two halves

    // Step 2: Recursively sort both halves
    left = sortList(left);
    right = sortList(right);

    // Step 3: Merge the two sorted halves
    return merge(left, right);
}

public static ListNode findMiddle(ListNode head) {
    if (head == null) return null;
    ListNode slow = head;
    ListNode fast = head;
    
    // Move `fast` by two steps and `slow` by one step
    // When `fast` reaches the end, `slow` will be at the middle
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;  // Middle node
}

public static ListNode merge(ListNode left, ListNode right) {
    // Dummy node to simplify merge process
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;

    // Merge the two sorted lists
    while (left != null && right != null) {
        if (left.data <= right.data) {
            current.next = left;
            left = left.next;
        } else {
            current.next = right;
            right = right.next;
        }
        current = current.next;
    }

    // Attach the remaining nodes if any
    if (left != null) {
        current.next = left;
    } else {
        current.next = right;
    }

    return dummy.next;  // Return the sorted list starting from the next of dummy
}

}
