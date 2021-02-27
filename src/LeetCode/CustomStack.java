package LeetCode;

import java.util.Arrays;

class CustomStack {
    private int [] array;
    private int size = -1;

    public CustomStack(int maxSize) {
        this.array = new int[maxSize];
    }

    public void push(int x) {
        if(this.size + 1 <= this.array.length - 1)
            this.array[++this.size] = x;
    }

    public int pop() {
        /**NOTE: wiping top value is not necessary
        *as size pointer will guard against upper level access
        Resetting value will only serve for memory benefit
         */
        if(this.size >= 0){
            return this.array[this.size--];
        }
        return -1;
    }

    public void increment(int k, int val) {
        if(k > this.array.length) k = this.array.length;
        for(int i = 0; i < k; i++) this.array[i] += val;
    }

        public int[] getStack(){
        return this.array;
    }

    public int getSize(){
        return this.size;
    }

    public static void main(String[] args) {
        CustomStack stack = new CustomStack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.increment(4,100);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(1086);
        stack.increment(4,100);
        stack.push(2);
        System.out.println(Arrays.toString(stack.getStack()));
        System.out.println(stack.getSize());
    }
}
