package LeetCode;

import java.util.HashMap;
import java.util.Stack;

public class GoalParserInterpretation {
    private HashMap<String,String> map;
    public GoalParserInterpretation(){
        this.map = new HashMap<>();
        this.map.put("G","G");
        this.map.put("()", "o");
        this.map.put("(al)","al");
    }

    public String interpret(String command) {
        char[] charArr = command.toCharArray();
        StringBuilder s = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i = charArr.length - 1; i >=0; i--){
            stack.push(charArr[i]);
        }
        while(!stack.isEmpty()){
            if(this.map.containsKey(Character.toString(stack.peek()))){
                s.append(stack.pop());
            }
            else{
                StringBuilder temp = new StringBuilder();
                if(stack.peek() == '('){
                    int distance = stack.search(')');
                    for(int i = 0; i < distance; i++){
                        temp.append(stack.pop());
                    }
                    s.append(this.map.get(temp.toString()));
                }
            }
        }
        return s.toString();
    }

    public static void main(String[] args) {
        GoalParserInterpretation g = new GoalParserInterpretation();
        System.out.println(g.interpret("(al)G(al)()()G"));
    }
}
