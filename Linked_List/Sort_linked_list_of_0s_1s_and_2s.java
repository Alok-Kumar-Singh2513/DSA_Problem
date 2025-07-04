package Linked_List;

public class Sort_linked_list_of_0s_1s_and_2s {
  public static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      next = null;
    }
  }
    static Node segregate(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node zeroHead = new Node(0);
        Node oneHead = new Node(0);
        Node twoHead = new Node(0);

        Node zeroTail = zeroHead;
        Node oneTail = oneHead;
        Node twoTail = twoHead;

        Node current = head;

        while (current != null) {
            if (current.data == 0) {
                zeroTail.next = current;
                zeroTail = zeroTail.next;
            } else if (current.data == 1) {
                oneTail.next = current;
                oneTail = oneTail.next;
            } else {
                twoTail.next = current;
                twoTail = twoTail.next;
            }
            current = current.next;
        }

        if (oneHead.next != null) {
            zeroTail.next = oneHead.next;
        } else {
            zeroTail.next = twoHead.next;
        }

        if (oneHead.next != null) {
            oneTail.next = twoHead.next;
        }
        
        twoTail.next = null;

        if (zeroHead.next != null) {
            return zeroHead.next;
        } else if (oneHead.next != null) {
            return oneHead.next;
        } else {
            return twoHead.next;
        }
    }

    // By counting the number of 0s, 1s, and 2s
    static Node segregateByCounting(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        int count0 = 0, count1 = 0, count2 = 0;
        Node current = head;

        while (current != null) {
            if (current.data == 0) {
                count0++;
            } else if (current.data == 1) {
                count1++;
            } else {
                count2++;
            }
            current = current.next;
        }

        current = head;
        for (int i = 0; i < count0; i++) {
            current.data = 0;
            current = current.next;
        }
        for (int i = 0; i < count1; i++) {
            current.data = 1;
            current = current.next;
        }
        for (int i = 0; i < count2; i++) {
            current.data = 2;
            current = current.next;
        }

        return head;
    }
}
