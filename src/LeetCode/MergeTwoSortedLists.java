package LeetCode;


public class MergeTwoSortedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode runner = head;

        if(l1 == null && l2 == null){
            return null;
        }
        else{
            while(l1!=null && l2!=null){
                if(l1.val >= l2.val){
                    runner.val = l2.val;
                    l2 = l2.next;
                }

                else if(l1.val < l2.val){
                    runner.val = l1.val;
                    l1 = l1.next;
                }
                runner.next = new ListNode();
                runner = runner.next;
            }

            if(l1 == null){
                while(l2.next != null){
                    runner.val = l2.val;
                    l2 = l2.next;
                    runner.next = new ListNode();
                    runner = runner.next;
                }
                runner.val = l2.val;
            }
            else{
                while(l1.next != null){
                    runner.val = l1.val;
                    l1 = l1.next;
                    runner.next = new ListNode();
                    runner = runner.next;
                }
                runner.val = l1.val;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists merge = new MergeTwoSortedLists();
        MergeTwoSortedLists.ListNode head = merge.new ListNode(1);
        MergeTwoSortedLists.ListNode node0 = merge.new ListNode(2);
        MergeTwoSortedLists.ListNode node01 = merge.new ListNode(4);
        head.next = node0;
        node0.next = node01;

        MergeTwoSortedLists.ListNode head1 = merge.new ListNode(1);
        MergeTwoSortedLists.ListNode node1 = merge.new ListNode(3);
        MergeTwoSortedLists.ListNode node12 = merge.new ListNode(4);
        MergeTwoSortedLists.ListNode node02 = merge.new ListNode(5);
        head1.next = node1;
        node1.next = node12;
        node12.next = node02;
        MergeTwoSortedLists.ListNode mergeList = merge.mergeTwoLists(head,head1);

        while(mergeList!=null){
            System.out.println(mergeList.val);
            mergeList = mergeList.next;
        }

    }
}
