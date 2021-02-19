package LeetCode;
import java.util.Stack;
public class BackspaceStringCompare {

    public Stack<Character> loadStack(String A){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i) == '#'){
                if(!stack.isEmpty())
                    stack.pop();
            }
            else{
                stack.push(A.charAt(i));
            }
        }
        return stack;
    }

    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackofS = loadStack(S);
        Stack<Character> stackofT = loadStack(T);
        return stackofS.toString().equals(stackofT.toString());
    }

    public static void main(String[] args) {
        BackspaceStringCompare b = new BackspaceStringCompare();
        System.out.println(b.backspaceCompare("ab#c","ad#c"));
        System.out.println(b.backspaceCompare("ab##","c#d#"));
        System.out.println(b.backspaceCompare("a##c","#a#c"));
        System.out.println(b.backspaceCompare("a#c","b"));
    }
}
