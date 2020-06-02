package LeetCode;

import java.math.BigInteger;
import java.util.HashMap;

public class MultiplyStrings {
    private static class Atoi {
        public enum Digits {
            ZERO(0),
            ONE(1),
            TWO(2),
            THREE(3),
            FOUR(4),
            FIVE(5),
            SIX(6),
            SEVEN(7),
            EIGHT(8),
            NINE(9);

            private int digit;

            Digits(int integer) {
                this.digit = integer;
            }

            public int getDigit() {
                return this.digit;
            }
        }

        public final static int TEN = 10;

        //FYI: Integer.MAX_VALUE + 1 = 2,147,483,648
        public static long myAtoi(String str) {
            char[] charArr = str.toCharArray();
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

            //TODO: given that we cannot use BigInteger, we must take advantage of the fact we are using strings here
            long accumulator = 0L;
            int arrLen = charArr.length - 1;
            for (int i = arrLen; i >= 0; i--) {
                int integerVal = map.get(charArr[i]);
                /**based on the index of the integer in the array,
                 * we will multiply integerVal by 10^n to replicate the
                 * proper positioning of the integer (i.e. being in the ones, tenths, hundredths, etc place)
                 **/
                if(i == arrLen - Digits.ZERO.getDigit()) {accumulator += integerVal * Math.pow(TEN, Digits.ZERO.getDigit());}
                else if(i == arrLen - Digits.ONE.getDigit()){accumulator += integerVal * Math.pow(TEN, Digits.ONE.getDigit());}
                else if(i == arrLen - Digits.TWO.getDigit()){accumulator += integerVal * Math.pow(TEN, Digits.TWO.getDigit());}
                else if(i == arrLen - Digits.THREE.getDigit()){accumulator += integerVal * Math.pow(TEN, Digits.THREE.getDigit());}
                else if(i == arrLen - Digits.FOUR.getDigit()){accumulator += integerVal * Math.pow(TEN, Digits.FOUR.getDigit());}
                else if(i == arrLen - Digits.FIVE.getDigit()){accumulator += integerVal * Math.pow(TEN, Digits.FIVE.getDigit());}
                else if(i == arrLen - Digits.SIX.getDigit()){accumulator += integerVal * Math.pow(TEN, Digits.SIX.getDigit());}
                else if(i == arrLen - Digits.SEVEN.getDigit()){accumulator += integerVal * Math.pow(TEN, Digits.SEVEN.getDigit());}
                else if(i == arrLen - Digits.EIGHT.getDigit()){accumulator += integerVal * Math.pow(TEN, Digits.EIGHT.getDigit());}
                else if(i == arrLen - Digits.NINE.getDigit()){accumulator += integerVal * Math.pow(TEN, Digits.NINE.getDigit());}
            }
            return accumulator;
        }
    }

    public static String multiply(String num1, String num2) {
        //FIXME: once we use multiplication, we are bounded to primitive type sizes... and we cannot use BigInteger
        return String.valueOf(Atoi.myAtoi(num1) * Atoi.myAtoi(num2));
    }
    public static void main(String[] args) {
        //"498828660196"
        //"840477629533"
        //"419_254_329_864_656_431_168_468"
        //"9_223_372_036_854_775_807"
        System.out.println(MultiplyStrings.multiply("498828660196", "840477629533"));
    }
}
