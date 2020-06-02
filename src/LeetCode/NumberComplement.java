package LeetCode;
/*
Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010.
So you need to output 2.
 */

import java.util.Arrays;
import java.util.Stack;

public class NumberComplement {
    public static int findComplement(int num) {
        return convertBinaryToInteger(complement(convertIntegerToBinary(num)));
    }

    public static int[] convertIntegerToBinary(int integer) {
        if(integer == 0){
            int[] zeroBit = {0};
            return zeroBit;
        }
        else {
            Stack<Integer> bitStack = new Stack<>();
            while (integer > 0) {
                bitStack.push(integer % 2);
                integer = (integer / 2);
            }
            int[] bitArray = new int[bitStack.size()];

            for (int i = 0; i < bitArray.length; i++) {
                bitArray[i] = bitStack.pop();
            }
            return bitArray;
        }
    }


    public static int[] complement(int[] bitArray) {
        for (int i = 0; i < bitArray.length; i++) {
            if (bitArray[i] == 1) {
                bitArray[i] = 0;
            } else {
                bitArray[i] = 1;
            }
        }
        return bitArray;
    }

    public static int convertBinaryToInteger(int[] bitArray) {
        double integer = 0;
        for (int i = bitArray.length - 1, j = 0; i >= 0; i--, j++) {
            integer += bitArray[i] * Math.pow(2, j);
        }
        return (int) integer;
    }

    public static void main(String[] args) {
        System.out.println(NumberComplement.findComplement(5));
    }
}