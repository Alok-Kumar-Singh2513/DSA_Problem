package Linked_List;

public class o21_Merge_Two_Sorted_Lists {
  public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  } 

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    while (list1 != null && list2 != null) {
        if (list1.val <= list2.val) {
            curr.next = list1;
            list1 = list1.next;
        } else {
            curr.next = list2;
            list2 = list2.next;
        }
        curr = curr.next;
    }
    curr.next = list1 == null ? list2 : list1;
    return dummy.next;
}
}
