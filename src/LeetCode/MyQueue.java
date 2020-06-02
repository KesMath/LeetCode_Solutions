package LeetCode;

import java.util.Stack;

class MyQueue {

    private Stack mainStack; //main storage where items will pop off in FIFO ordering
    private Stack cache; //used as temp storage when pushed is called > 1

    public MyQueue() {
        this.mainStack = new Stack();
        this.cache = new Stack();
    }

    private void clearCache(){
        this.cache.removeAllElements();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        // in order to get order correct load a temp stack, S1, and pop the stack per number of elements it contains,
        // cache those values onto another stack, S2, then push onto the instance stack those cached values to get it Queue order!
        // i.e. this.stack.push(cacheStack.pop());
        if(this.mainStack.size() == 0)
            this.mainStack.push(x);

        else{
            while(!this.mainStack.isEmpty()){
                this.cache.push(this.mainStack.pop());
            }
            this.mainStack.push(x);

            while(!this.cache.isEmpty()){
                this.mainStack.push(this.cache.pop());
            }
            //NOTE: cleanup cache after each push to prevent duplicates!
            //TODO: to aid with performance, we can maintain items in cache and only push element it doesn't have!
            // This technique will avoid redundant push entries. For the sake of simplicity, we can avoid this for now.
            this.clearCache();
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(this.mainStack.size() > 0)
            return (int) this.mainStack.pop();
        return -1;
    }

    /** Get the front element. */
    public int peek() {
        if(this.mainStack.size() > 0)
            return (int) this.mainStack.peek();
        return -1;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.mainStack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(55);
        q.push(100);
        q.push(300);
        q.push(500);
        q.push(60000);

        while(!q.empty()){
            System.out.println(q.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */