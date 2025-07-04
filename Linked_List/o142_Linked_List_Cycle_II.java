package Linked_List;
import java.util.HashSet;
import java.util.Set;
public class o142_Linked_List_Cycle_II {
  public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
  public static ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) {
        return null;
    }

    ListNode slow = head;
    ListNode fast = head;

    // Step 1: Determine if a cycle exists
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast) {
            // Cycle detected
            break;
        }
    }

    // If no cycle is detected
    if (fast == null || fast.next == null) {
        return null;
    }

    // Step 2: Find the entry point of the cycle
    slow = head; // Move slow to the start of the list
    while (slow != fast) {
        slow = slow.next;
        fast = fast.next;
    }

    return slow; 
}


// By hashing
public static ListNode detectCycleUsingHashing(ListNode head) {
    if (head == null) return null;

    Set<ListNode> visited = new HashSet<>();
    ListNode current = head;

    while (current != null) {
        if (visited.contains(current)) {
            return current; // Cycle detected, return the node where the cycle begins
        }
        visited.add(current);
        current = current.next;
    }

    return null; // No cycle detected
  }
  
}


    

