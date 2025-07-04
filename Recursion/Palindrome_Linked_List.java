package Recursion;

import java.util.Stack;

public class Palindrome_Linked_List {
  public static class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }
  static Stack<Integer> stack = new Stack<>();

  static boolean isPalindrome(Node head) {
      Node temp = head;
      while (temp != null) {
          stack.push(temp.data);
          temp = temp.next;
      }
      return checkWithStack(head);
  }

  static boolean checkWithStack(Node node) {
      if (node == null) return true;

      boolean result = checkWithStack(node.next);

      if (!result) return false;
      int top = stack.pop();
      return node.data == top;
  }

public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(2);
    head.next.next.next.next = new Node(1);

    if (isPalindrome(head)) {
      System.out.println("The linked list is a palindrome.");
    } else {
      System.out.println("The linked list is not a palindrome.");
    }
}
}
