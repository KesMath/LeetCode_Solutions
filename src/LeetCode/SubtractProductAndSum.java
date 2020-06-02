package LeetCode;

import java.util.HashMap;

public class SubtractProductAndSum {
    public static int subtractProductAndSum(int n) {
        if (n >= 0 && n < 10) {
            return 0;

        } else {
            char[] charArray = Integer.toString(n).toCharArray();
            HashMap<Character, Integer> map = new HashMap<>();
            map.put('0', 0);
            map.put('1', 1);
            map.put('2', 2);
            map.put('3', 3);
            map.put('4', 4);
            map.put('5', 5);
            map.put('6', 6);
            map.put('7', 7);
            map.put('8', 8);
            map.put('9', 9);

            int productOfDigits = 1;
            int sumOfDigits = 0;

            for (int i = 0; i < charArray.length; i++) {
                int digit = map.get(charArray[i]);
                productOfDigits *= digit;
                sumOfDigits += digit;
            }
            return productOfDigits - sumOfDigits;
        }
    }

    public static void main(String[] args) {
        System.out.println(SubtractProductAndSum.subtractProductAndSum(4421));
    }
}
