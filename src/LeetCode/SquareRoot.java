package LeetCode;
import java.lang.Math;

class Solution {

    //what to positive numbers (i*i) would yield x??
    public static int mySqrt(int x) {
        int sqrt = 0;
        for (int i = 1; i <= x; i++) {
            if (i * i >= x) {
                sqrt = i * i > x ? --i : i;
                break;
            }
        }
        return sqrt;
    }

    public static int modulo (int dividend, int divisor){
        return 0;
    }

    public static int divide (int quotient, int dividend){return 0;}

    public static int multiply (int a, int b){
        int result = 0;
        if(a > 0 && b > 0){
            for(int i = 0; i < b; i++){
                result += a;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //System.out.println(Solution.mySqrt(2147483647));
        System.out.println(Solution.multiply(40,100));
    }
}