public class o26_Remove_End_LL {
  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode dummy = new ListNode(0); // dummy node before head
      dummy.next = head;

      ListNode first = dummy;
      ListNode second = dummy;

      // Move first n+1 steps ahead so there's a gap of n between first and second
      for (int i = 0; i <= n; i++) {
        first = first.next;
      }

      // Move both pointers until first reaches end
      while (first != null) {
        first = first.next;
        second = second.next;
      }

      // Delete the nth node from end
      second.next = second.next.next;

      return dummy.next;
    }
  }
}

// Helper to print the list
