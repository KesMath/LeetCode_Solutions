package LeetCode;

import java.util.Stack;
public class ReverseLinkList {
    public static ListNode reverseList(ListNode head) {
        ListNode topPointer = head;
        Stack stack = new Stack();
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        //pointing head back to the top so we can override values from top -> bottom approach
        head = topPointer;
        while(!stack.isEmpty()){
            Integer val = (Integer) stack.pop();
            head.val = val;
            head = head.next;
        }

        /**given that 'head' and 'topPointer' refers to same ListNode in memory
         * but pointed to different nodes, we can return 'topPointer' instead since it
         * will show all values in reverse order!
        **/
        return topPointer;
    }

    public static void display(ListNode node) {
    while (node != null) {
        System.out.println(node.val);
        node = node.next;
    }
}

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(9);
        node2.next = node3;
        node1.next = node2;
        head.next = node1;
        System.out.println(head.val);
        System.out.println(head.next.val);
        System.out.println(head.next.next.val);
        System.out.println(head.next.next.next.val);
        System.out.println("---- AFTER REVERSAL ----");
        ReverseLinkList.reverseList(head);
    }
}
