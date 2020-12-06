package LeetCode;

import java.util.Arrays;

public class MovingAverage {
    private int[] avgArr;
    private int windowPointer = 0; //this pointer simulates the leftmost entry in the sliding window that will be ejected
    private int window;
    private int arrSize;

    public MovingAverage(int size) {
        this.avgArr = new int[size];
        this.window = size;
    }

    public double getAvg(int[] arr){
        double sum = 0.0;
        for(int i = 0; i < arr.length; i++){
            sum+=arr[i];
        }
        return sum/this.arrSize;
    }

    public double next(int val) {
        if(this.arrSize == this.window) {
            //System.out.println("pointer: "+ windowPointer);
            this.avgArr[windowPointer] = val;
            windowPointer++;
            //System.out.println("pointer: "+ windowPointer);
            //System.out.println(Arrays.toString(this.avgArr));
            if(windowPointer == this.window){
                windowPointer = 0;
            }
        }
        else{
            this.avgArr[this.arrSize] = val;
            arrSize++;
        }
        return this.getAvg(this.avgArr);
    }

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));
        System.out.println(m.next(4));
        System.out.println(m.next(6));
        System.out.println(m.next(11));
    }
}
