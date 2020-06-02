package LeetCode;

import java.util.HashSet;

public class HappyNumber {
    public static int sumOfSquares(int num) {
        int accum = 0;
        if (num >= 0) {
            while (num != 0) {
                int rightmostDigit = num % 10;
                accum += rightmostDigit * rightmostDigit;
                num -= rightmostDigit;
                num /= 10;
            }
        }
        return accum;
    }
    public static boolean isHappy(int num){
        HashSet<Integer> set = new HashSet<>(); //If recursive operation returns back to any e in this set, num is not happy!
        int sumOfSquares = sumOfSquares(num);
        while(sumOfSquares != 1){
            if (set.contains(sumOfSquares)) {
                return false;
                }
            set.add(sumOfSquares);
            System.out.println(sumOfSquares);
            sumOfSquares = sumOfSquares(sumOfSquares);
            }
        return true;
    }
    public static void main(String[] args) {
        int [] happy = {1, 7, 10, 13, 19, 23, 28, 31, 32, 44, 49, 68, 70, 79, 82, 86, 91, 94, 97, 100};
        int [] unhappy = {2, 3, 4, 5, 6, 8, 9, 11, 12, 14, 15, 16, 17, 18, 20};
        //System.out.println(HappyNumber.sumOfSquares(Integer.MAX_VALUE));
//        for (int b : unhappy){
//            System.out.println(HappyNumber.isHappy(b));
//        }
        System.out.println(HappyNumber.isHappy(2));
    }
}
