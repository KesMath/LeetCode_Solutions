package LeetCode;

class MinStack {

    public class ListNode {
        int val;
        ListNode next;
        ListNode previous;
        ListNode(int x) { val = x; }
        ListNode(){}
    }

    private ListNode linkList;
    private int size;
    private int min;
    //private int prevMin;

    public MinStack() {
        this.linkList = new ListNode();
    }

    public void push(int x) {
        if(this.size == 0) {
            linkList.val = x;
            this.size++;
            min = x;
        }
        //TODO: this approach only stores 2 elements at a time...needs refactoring!
        else{
            linkList.previous = linkList;
            linkList = linkList.next;
            linkList.val = x;
            size++;
            if (x < this.min){
                //this.prevMin = this.min;
                this.min = x;
            }
        }
    }
    //TODO: need mechanism to recompute newMin assuming it gets popped
    public void pop() {
        /**
         linklist is pointed to the top of the stack... so pointing it to previous is disconnecting
         its reference to its top where GC will remove it eventually
         **/
        linkList = linkList.previous;
        this.size--;
        if(size >= 0)
            //pointing back one so pop can be called 'size' times
            linkList.previous = linkList.previous.previous;
    }

    public int getSize(){
        return this.size;
    }

    public int top() {
        return this.linkList.val;
    }

    public int getMin() {
        return this.min;
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
