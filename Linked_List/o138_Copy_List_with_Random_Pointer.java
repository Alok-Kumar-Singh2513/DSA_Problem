package Linked_List;

import java.util.HashMap;

public class o138_Copy_List_with_Random_Pointer {
    public static class Node {
        int val;
        Node next;
        Node random;

        Node(int x) {
            val = x;
        }
    }

    // HashMap solution
    // Time complexity: O(n)
    // Space complexity: O(n)
   public Node copyRandomList(Node head) {
        if(head==null)return head;
        Node curr=head;
        HashMap<Node,Node> map=new HashMap<>();
        while(curr!=null){
            map.put(curr,new Node(curr.val));
            curr=curr.next;

        }

         curr=head;

         while(curr!=null){
            // Copy next pointer
            map.get(curr).next = map.get(curr.next);  
            // Copy random pointer
            map.get(curr).random = map.get(curr.random); 
            curr = curr.next;
         }

         return map.get(head);

    }
}
