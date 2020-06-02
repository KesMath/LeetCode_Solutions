package LeetCode;


public class ValidParentheses {
    //two pointer approach starting in middle
    public static boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        boolean isValid = true;

        for(int i = (charArray.length/2)-1, j = charArray.length/2; i >= 0; i--, j++){
            if (charArray[i] == '(' && charArray[j] == ')' ||
                charArray[i] == '[' && charArray[j] == ']' ||
                charArray[i] == '{' && charArray[j] == '}'){}
            else{
                //skip to next corresponding pair(assuming size is not breached)
                isValid = false;
                break;
            }
        }
        return isValid;
    }
    public static void main(String[] args) {
        System.out.println(ValidParentheses.isValid("()[]{}"));
    }
}