package LeetCode;

import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {
    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        boolean isPopped;
        for(int i = 0; i < s.length(); i++){
            isPopped = false;
            if(!stack.isEmpty()){
                if(stack.peek() == '(' && s.charAt(i) == ')'){
                    stack.pop();
                    isPopped = true;
                }
            }
            if(!isPopped)
                stack.add(s.charAt(i));
        }
        return stack.size();
    }

    public static void main(String[] args) {
        System.out.println(MinimumAddToMakeParenthesesValid.minAddToMakeValid("())"));
        System.out.println(MinimumAddToMakeParenthesesValid.minAddToMakeValid("((("));
        System.out.println(MinimumAddToMakeParenthesesValid.minAddToMakeValid("()"));
        System.out.println(MinimumAddToMakeParenthesesValid.minAddToMakeValid("()))(("));
    }
}
