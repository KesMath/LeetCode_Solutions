package LeetCode;

public class DeleteNode {
    public static void deleteNode(ListNode node, int n) {
        if (node.val == n) {
            node = node.next;
        }
        else {
            while (node != null) {
                if (node.next.val == n) {
                    node.next = node. next.next;
                    break;
                }
                node = node.next;
            }
        }
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
        DeleteNode.deleteNode(head, 4);
        System.out.println("-----Main Method-----");
        //TODO: fix head issue
        //TODO: implement logic to handle when n is not present in list
        DeleteNode.display(head);
//        System.out.println(head.val);
//        System.out.println(head.next.val);
//        System.out.println(head.next.next.val);
        //System.out.println(head.next.next.next.val);
    }
}