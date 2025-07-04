package Linked_List;

public class Add_1_to_Linked_List_Number {
  public static class Node {
    int val;
    Node next;

    Node(int x) {
      val = x;
      next = null;
    }
  }
   
    // By reversing                         
    public static Node addOne(Node head) {
        if (head == null) {
            return new Node(1);
        }

        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        Node reversedHead = prev;
        Node carryNode = reversedHead;
        int carry = 1;

        while (carryNode != null && carry > 0) {
            int sum = carryNode.val + carry;
            carryNode.val = sum % 10;
            carry = sum / 10;
            carryNode = carryNode.next;
        }

        if (carry > 0) {
            Node newNode = new Node(carry);
            newNode.next = reversedHead;
            return newNode;
        }

        // Reverse the list back to original order
        prev = null;
        current = reversedHead;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev; // New head of the modified list
    }
  
}
