package LeetCode;// You are given two non-empty linked lists representing two non-negative integers.
// The digits are stored in reverse order and each of their nodes contain a single digit.
// Add the two numbers and return it as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

//EX:
// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//        Output: 7 -> 0 -> 8
//        Explanation: 342 + 465 = 807.


//(5 -> 6 -> 4)
//(2 -> 4 -> 3)
//(7 -> 0 -> 8)


public class AddTwoNumbers {


    public class ListNode{
          //TODO: use super calls to assign values to parent class
          int val;
          ListNode next;
          //for this.display()
          int size;
          private ListNode head;

          ListNode(int x) {
              val = x;
              size++;
          }

        //added default constructor
          ListNode() {}

          public boolean isEmpty() {
              return (size == 0) ? true : false; }

          public void insert(int integer) {
            //implying list is empty
              if (next == null) {
                  ListNode head = new ListNode(integer);
                  size++;
                  next = head;
                  //for this.display()
                  this.head = head;
            } else {
                  ListNode newNode = new ListNode(integer);
                  size++;
                  //- (1) - linking newNode as the next node within the chain
                  next.next = newNode;
                  //- (2) - setting a new value or updating reference for next so linkage can continue
                  // - (3) - If this line wasn't here then after N insertions, only the Nth one would be present!
                  // all previous ones would've been overridden
                  next = newNode;
            }
        }

        //remove from the head and reassign reference to next element iff next element is not null
          public int remove(){
              int result;
              if (head == null){
                  throw new NullPointerException("Cannot remove from an empty list!");
              } else{
                  result = head.val;
                  head = head.next;
                  size--;
              }
              return result;
        }

        //for debugging purposes
          public void display() {
              while (this.size > 0) {
                  System.out.println(head.val);
                  // value on RHS references the successor Node... the LHS shadows 'next' phrase so while loop can proceed forth
                  head = head.next;
                  size--;
            }
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int queue1Size = l1.size;
        int queue2Size = l2.size;

        //add zero padding to properly perform digit wise addition
        if (queue1Size < queue2Size) {
            int sizeDiff = queue2Size - queue1Size;
            for (int i = 0; i < sizeDiff; i++) {
                l1.insert(0);
            }
        } else if (queue1Size > queue2Size) {
            int sizeDiff = queue1Size - queue2Size;
            for (int i = 0; i < sizeDiff; i++) {
                l2.insert(0);
            }
        }
        //final computation step performing digit wise addition
        //Note: either queueSize can work given that they are same lengths now
        ListNode result = new ListNode();
        int carryOver = 0;
        int sum;

        while (!l1.isEmpty()) {
            sum = l1.remove() + l2.remove() + carryOver;
            if (sum >= 10) {
                //keeping carryover strictly at 1 going from CarrOver addn to CarryOver addn
                if (carryOver != 1)
                    carryOver++;
                result.insert(sum - 10);
            } else {
                //resetting value of carryover going from CarryOver addn to Non-CarryOver addn
                if (carryOver == 1)
                    carryOver--;
                result.insert(sum);
            }
        }
        //check to see if carryover contains 1 after looping... represents a SUM(A+B) going from N -> N+1 digits long
        //i.e. SUM(99 + 01) goes from (2 -> 3) digits
        if (carryOver == 1) {
            result.insert(carryOver);
        }
        return result;
    }

    public static void main(String[] args) {
        AddTwoNumbers x = new AddTwoNumbers();

        //logic to test insertions
        ListNode y = x.new ListNode();
        y.insert(7);
        y.insert(6);
        y.insert(8);
        //y.display();

        ListNode p = x.new ListNode();
        p.insert(3);
        p.insert(2);
        p.insert(9);
        //p.display();

        ListNode gg = x.addTwoNumbers(y,p);
        gg.display();
    }
}
