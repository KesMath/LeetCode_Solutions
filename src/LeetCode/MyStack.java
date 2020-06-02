package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> mainQueue;
    private Queue<Integer> cache;

    public MyStack() {
        this.mainQueue = new LinkedList<>();
        this.cache = new LinkedList<>();
    }

    private void clearCache(){
        this.cache.clear();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(this.mainQueue.size() == 0){
            this.mainQueue.add(x);
        }

        else{
            while(!this.mainQueue.isEmpty()){
                this.cache.add(this.mainQueue.remove());
            }
            this.mainQueue.add(x);

            while(!this.cache.isEmpty()){
                this.mainQueue.add(this.cache.remove());
            }
            this.clearCache();
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(!this.mainQueue.isEmpty()){
            return this.mainQueue.remove();
        }
        return -1;
    }

    /** Get the top element. */
    public int top() {
        if(!this.mainQueue.isEmpty()){
            return this.mainQueue.peek();
        }
        return -1;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return this.mainQueue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);

        while(!s.empty()){
            System.out.println("popped: " + s.pop());
            System.out.println("topped: " + s.top());
        }

    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */