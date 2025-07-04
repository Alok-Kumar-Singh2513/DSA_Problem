package Linked_List;
import java.util.*;
public class o206_Reverse_Linked_List {
    public static class ListNode{
        int data;
        ListNode next;
        public ListNode(int data){
            this.data=data;
            this.next=null;
        }
    }
    // Normal
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        while(head !=null){
            ListNode next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
// Using Stack
    public ListNode reverseListUsingStack(ListNode head) {
        if (head == null) return null;
        
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        
        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        
        ListNode newHead = stack.pop();
        current = newHead;
        
        while (!stack.isEmpty()) {
            current.next = stack.pop();
            current = current.next;
        }
        
        current.next = null; 
        return newHead;
    }
// Reverse Recursion
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head; 
        }
        
        ListNode newHead = reverseListRecursive(head.next); 
        head.next.next = head; 
        head.next = null; 
        
        return newHead; 
    }

    public static void main(String[] args) {
        // Example usage (optional, for testing purposes)
        // o206_Reverse_Linked_List reverser = new o206_Reverse_Linked_List();

        // // Create a list: 1 -> 2 -> 3 -> 4 -> 5
        // ListNode head = new ListNode(1);
        // head.next = new ListNode(2);
        // head.next.next = new ListNode(3);
        // head.next.next.next = new ListNode(4);
        // head.next.next.next.next = new ListNode(5);

        // System.out.println("Original List:");
        // printList(head);

        // // Test Iterative
        // ListNode reversedIterative = reverser.reverseList(head);
        // System.out.println("Reversed (Iterative):");
        // printList(reversedIterative);

        // // Reset list for Stack method
        // head = new ListNode(1);
        // head.next = new ListNode(2);
        // head.next.next = new ListNode(3);
        // ListNode reversedStack = reverser.reverseListUsingStack(head);
        // System.out.println("Reversed (Stack):");
        // printList(reversedStack);

        // // Reset list for Recursive method
        // head = new ListNode(1);
        // head.next = new ListNode(2);
        // head.next.next = new ListNode(3);
        // ListNode reversedRecursive = reverser.reverseListRecursive(head);
        // System.out.println("Reversed (Recursive):");
        // printList(reversedRecursive);
    }

    // Helper method to print the list (for testing)
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}