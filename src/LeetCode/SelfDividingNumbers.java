package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SelfDividingNumbers {

    public static Queue<Integer> parseDigits(int num){
        LinkedList<Integer> queue = new LinkedList<>();
        if (num >=0){
            while(num !=0){
                if(num%10 == 0){
                    queue.add(0, 0);
                }
                else{
                    int rightmostDigit = num % 10;
                    queue.add(0,rightmostDigit);
                    num-=rightmostDigit;
                }
                num/=10;
            }
        }
        return queue;
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        // we can blacklist multiple of 10's
        List<Integer> list = new LinkedList<Integer>();
        for(;left<=right; left++){
            if(left % 10 !=0){
                list.add(left);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        //System.out.println(SelfDividingNumbers.selfDividingNumbers(1,22).toString());
        Queue<Integer> digits = SelfDividingNumbers.parseDigits(Integer.MAX_VALUE);
        System.out.println(Arrays.toString(digits.toArray()));
        System.out.println(SelfDividingNumbers.selfDividingNumbers(1,22).toString());
    }
}
