package Linked_List;

public abstract class Palindrome_Linked_List {
  public static class Node{
    int data;
    Node next;
    public Node(int data){
      this.data=data;
      this.next=null;
    }
  }
  public static Node reverse(Node head){
    Node prev=null;
    while(head!=null){
      Node next=head.next;
      head.next=prev;
      prev=head;
      head=next;
    }
    return prev;
  }
  public static boolean isPalindrome(Node head) {
    Node slow = head;
    Node fast = head;
    while(fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    Node secondHalf = reverse(slow);
    Node firstHalf = head;
    while(secondHalf != null) {
      if(firstHalf.data != secondHalf.data) {
        return false;
      }
      firstHalf = firstHalf.next;
      secondHalf = secondHalf.next;
    }
    return true;

  }
}
