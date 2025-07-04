package Linked_List;
import java.util.HashSet;
import java.util.Set;
public class Length_of_Loop_in_LL {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

  public int cycleLength(ListNode head) {
    if (head == null || head.next == null) {
        return 0;  // No cycle
    }

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;            
        fast = fast.next.next;                      

        if (slow == fast) {           // Cycle detected
            // Step 2: Calculate the length of the cycle
            int length = 1;
            ListNode current = slow.next;
            while (current != slow) {
                length++;
                current = current.next;
            }
            return length;
        }
    }

    return 0;
}

// By hashing
public int cycleLengthUsingHashing(ListNode head) {
    if (head == null) return 0;

    Set<ListNode> visited = new HashSet<>();
    ListNode current = head;

    while (current != null) {
        if (visited.contains(current)) {
            // Cycle detected, calculate the length
            int length = 1;
            ListNode temp = current.next;
            while (temp != current) {
                length++;
                temp = temp.next;
            }
            return length;
        }
        visited.add(current);
        current = current.next;
    }

    return 0; // No cycle detected
}

}
