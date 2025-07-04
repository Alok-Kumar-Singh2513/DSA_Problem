package Linked_List;

import java.util.Stack;

public class o234_Palindrome_Linked_List {
  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public static boolean isPalindrome(ListNode head) {
    Stack<Integer> st = new Stack<>();
    ListNode temp = head;

    while (temp != null) {
      st.push(temp.val);

      temp = temp.next;
    }

    temp = head;
    // Compare
    while (temp != null) {
      if (temp.val != st.peek()) {

        return false;
      }

      st.pop();

      temp = temp.next;
    }
    return true;
  }

  // By pointers
  public static boolean isPalindromeUsingPointers(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }

    // Step 1: Find the middle of the linked list
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    // Step 2: Reverse the second half of the linked list
    ListNode prev = null;
    ListNode current = slow;

    while (current != null) {
      ListNode nextTemp = current.next;
      current.next = prev;
      prev = current;
      current = nextTemp;
    }

    // Step 3: Compare the first half and the reversed second half
    ListNode firstHalf = head;
    ListNode secondHalf = prev;

    while (secondHalf != null) {
      if (firstHalf.val != secondHalf.val) {
        return false;
      }
      firstHalf = firstHalf.next;
      secondHalf = secondHalf.next;
    }

    return true;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(2);
    head.next.next.next = new ListNode(1);

    System.out.println(isPalindrome(head)); // Output: true

  }
}
