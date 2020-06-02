package LeetCode;
import java.util.LinkedList;

public class AddTwoNumbersSecondSolution {

    public static void linkNodeReferences(ListNode head, LinkedList<Integer> linkedList){
        if (!linkedList.isEmpty()){
            ListNode newNode = new ListNode(linkedList.remove());
            head.next = newNode;
            head = newNode;
            linkNodeReferences(head, linkedList);
        }
    }

    public static ListNode mapLinkListToListNode(LinkedList<Integer> linkedList){
        //establishing head's value initally into 'result' pre-looping
        int firstVal = linkedList.remove();
        ListNode head = new ListNode(firstVal);

        linkNodeReferences(head, linkedList);

        return head;
    }

    public static LinkedList<Integer> mapListNodeToLinkList(ListNode listNode) {
        LinkedList<Integer> queue = new LinkedList<>();
        while (listNode != null) {
            queue.add(listNode.val);
            listNode = listNode.next;
        }
        return queue;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> queue1 = mapListNodeToLinkList(l1);
        LinkedList<Integer> queue2 = mapListNodeToLinkList(l2);
        LinkedList<Integer> resultQueue = new LinkedList<>();

        //System.out.println(queue1.toString());
        //System.out.println(queue2.toString());

        int queue1Size = queue1.size();
        int queue2Size = queue2.size();

        //add zero padding to properly perform digit wise addition
        if (queue1Size < queue2Size) {
            int sizeDiff = queue2Size - queue1Size;
            for (int i = 0; i < sizeDiff; i++) {
                queue1.add(0);
            }
        } else if (queue1Size > queue2Size) {
            int sizeDiff = queue1Size - queue2Size;
            for (int i = 0; i < sizeDiff; i++) {
                queue2.add(0);
            }
        }
        //final computation step performing digit wise addition
        //Note: either queueSize can work given that they are same lengths now
        int carryOver = 0;
        int sum;

        while (!queue1.isEmpty()){
            sum = queue1.remove() + queue2.remove() + carryOver;
            if (sum >= 10) {
                //keeping carryover strictly at 1 going from CarrOver addn to CarryOver addn
                if (carryOver != 1)
                    carryOver++;
                resultQueue.add(sum - 10);
            } else {
                //resetting value of carryover going from CarryOver addn to Non-CarryOver addn
                if (carryOver == 1)
                    carryOver--;
                resultQueue.add(sum);
            }
        }
        //check to see if carryover contains 1 after looping... represents a SUM(A+B) going from N -> N+1 digits long
        //i.e. SUM(99 + 01) goes from (2 -> 3) digits
        if (carryOver == 1) {
            resultQueue.add(carryOver);
        }
        System.out.println(resultQueue.toString());
        return mapLinkListToListNode(resultQueue);
    }

    public static void main(String[] args) {
        AddTwoNumbersSecondSolution x = new AddTwoNumbersSecondSolution();

        ListNode y = new ListNode(7);
        ListNode g = new ListNode(6);
        ListNode t = new ListNode(8);
        g.next = t;
        y.next = g;
        //y.display();

        ListNode p = new ListNode(4);
        ListNode w = new ListNode(2);
        ListNode e = new ListNode(4);
        w.next = e;
        p.next = w;
        //p.display();

        ListNode gg = x.addTwoNumbers(y,p);
        System.out.println(gg.val);
        System.out.println(gg.next.val);
        System.out.println(gg.next.next.val);
        System.out.println(gg.next.next.next.val);
    }
}
