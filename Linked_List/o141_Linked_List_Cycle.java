package Linked_List;
import java.util.HashSet;
import java.util.Set;
public class o141_Linked_List_Cycle {
  public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
        return false;
    }
    
    ListNode slow = head;
    ListNode fast = head;
    
    while (fast != null && fast.next != null) {
        slow = slow.next;          
        fast = fast.next.next;        
        
        if (slow == fast) {           
            return true;
        }
    }
    
    return false;  
}
// Hashmap using
public boolean hasCycleUsingHashMap(ListNode head) {
    if (head == null) return false;
    
    Set<ListNode> visited = new HashSet<>();
    ListNode current = head;
    
    while (current != null) {
        if (visited.contains(current)) {
            return true; 
        }
        visited.add(current);
        current = current.next;
    }
    
    return false;  
  }
}
