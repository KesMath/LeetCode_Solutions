package LeetCode;

public class MovingAverage {
    /**instead of using a Collections import where one can retrieve the last n items,
     * this approach is more memory efficient by updating the values within an array.
     * We can simulate a sliding window effect that the
     * leftmost item in a list will always be disregarded or ejected by keeping track of a
     * circular pointer that handles this rotation.
     **/
    private int[] avgArr;
    private int circularPointer = 0; //this pointer simulates the leftmost entry in the sliding window that will be ejected
    private int window;
    private int arrSize;
    private double sum = 0.0;

    public MovingAverage(int size) {
        this.avgArr = new int[size];
        this.window = size;
    }

    public double next(int val) {
        if(this.arrSize == this.window) {
            sum-= this.avgArr[circularPointer];
            this.avgArr[circularPointer] = val;
            circularPointer++;
            sum+=val;
            if(circularPointer == this.window){
                circularPointer = 0;
            }
        }
        else{
            this.avgArr[this.arrSize] = val;
            sum+=val;
            arrSize++;
        }
        return sum/this.arrSize;
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
