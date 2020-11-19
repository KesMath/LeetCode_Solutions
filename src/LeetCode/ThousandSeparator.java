package LeetCode;

import java.util.Stack;

public class ThousandSeparator {
    public static String thousandSeparator(int n) {
        Stack<Character> stack = new Stack<>();
        StringBuilder str = new StringBuilder();
        char [] digitArr = Integer.toString(n).toCharArray();
        int cout = 0;
        for(int i = 0; i < digitArr.length; i++){
            stack.add(digitArr[i]);
        }

        while(!stack.isEmpty()){
            str.insert(0, stack.pop());
            cout++;
            if(cout == 3 && stack.size() != 0){
                str.insert(0, '.');
                cout = 0;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(ThousandSeparator.thousandSeparator(1000000));
        System.out.println(ThousandSeparator.thousandSeparator(0));
        System.out.println(ThousandSeparator.thousandSeparator(10000));
        System.out.println(ThousandSeparator.thousandSeparator(1000));
        System.out.println(ThousandSeparator.thousandSeparator(1234567));
        System.out.println(ThousandSeparator.thousandSeparator(123456789));
        System.out.println(ThousandSeparator.thousandSeparator(51040));
    }
}
