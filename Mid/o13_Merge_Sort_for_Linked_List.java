// package Mid;

public class o13_Merge_Sort_for_Linked_List {
  public static class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
  }
  public static Node merge(Node left, Node right) {
    if (left == null) return right;
    if (right == null) return left;
    Node result = new Node(0);
    Node current = result;
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
    if (left != null) current.next = left;
    else current.next = right;

    return result.next;
}
public static Node findMid(Node head) {
    if (head==null || head.next == null) return head;
    Node slow = head;
    Node fast = head;
    while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    
     return slow;
}

public static Node mergeSort(Node head) {
    if ( head.next == null) return head;
    Node middle = findMid(head);
    Node h2=middle.next;
    middle.next=null;
    Node leftSorted = mergeSort(head);
    Node rightSorted = mergeSort(h2);
    return merge(leftSorted, rightSorted);
}
}
