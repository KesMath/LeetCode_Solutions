package LeetCode;
import java.util.Stack;

public class ConvertBinaryNumberInLinkedListToInteger {
    public static int getDecimalValue(ListNode head) {
        int decimal = 0;
        int stackPointer = 0;
        Stack<Boolean> stack = new Stack<>();
        while(head !=null){
            System.out.println(head.val);
            if (head.val == 1){
                stack.push(true);
            }
            else{
                stack.push(false);
            }
            head = head.next;
        }

        while(!stack.isEmpty()){
            if(stack.pop() == true){
               decimal += (int)Math.pow(2, stackPointer);
            }
            stackPointer++;
        }

        return decimal;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(0);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(0);
        c.next = d;
        b.next = c;
        a.next = b;
        System.out.println(ConvertBinaryNumberInLinkedListToInteger.getDecimalValue(a));
    }
}
