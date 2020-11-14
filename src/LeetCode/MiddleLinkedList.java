package LeetCode;
import java.util.HashMap;

public class MiddleLinkedList {
     //* Definition for singly-linked list.
     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
     public ListNode middleNode(ListNode head) {
         HashMap<Integer, ListNode> map = new HashMap<>();
         int cout = 0;
         while(head != null){
            map.put(cout, head);
            head = head.next;
            cout++;
        }
        if(cout % 2 == 0){
            return map.get((cout / 2));
        }
        else{
            return map.get((int)Math.floor(cout/2));
        }
     }

    public static void main(String[] args) {
        MiddleLinkedList m = new MiddleLinkedList();
        ListNode a = m.new ListNode(9);
        ListNode b = m.new ListNode(8);
        ListNode c = m.new ListNode(7);
        ListNode d = m.new ListNode(6);
        ListNode e = m.new ListNode(5);
        ListNode f = m.new ListNode(10);
        e.next = f;
        d.next = e;
        c.next = d;
        b.next = c;
        a.next = b;
        //while(a!= null){
            //System.out.println(a.val);
            //a = a.next;
        //}
        System.out.println(m.middleNode(a).val);
    }
}
