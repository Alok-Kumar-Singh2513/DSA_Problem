public class o49_intersection_of_two_linked_lists {
  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode getIntersectionNode(ListNode a, ListNode b) {
    ListNode tempA = a;
    ListNode tempB = b;
    int lengthA = 0;
    while (tempA != null) {
      lengthA++;
      tempA = tempA.next;
    }

    int lengthB = 0;
    while (tempB != null) {
      lengthB++;
      tempB = tempB.next;
    }

    tempA = a;
    tempB = b;
    if (lengthA > lengthB) {
      int steps = lengthA - lengthB;
      for (int i = 1; i <= steps; i++) {
        tempA = tempA.next;
      }
    } else {
      int steps = lengthB - lengthA;
      for (int i = 1; i <= steps; i++) {
        tempB = tempB.next;
      }
    }
    while (tempA != tempB) {
      tempA = tempA.next;
      tempB = tempB.next;

    }
    return tempA;
  }
}
