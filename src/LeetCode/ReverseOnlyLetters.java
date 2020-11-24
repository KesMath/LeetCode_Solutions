package LeetCode;

import java.util.HashMap;
import java.util.Stack;

public class ReverseOnlyLetters {
    public static boolean isNotLetters(int c){
        /* returns true if characters are not letters
        that is, their ASCII value (assuming range of 33 <= S[i].ASCIIcode <= 122 as the problem defined)
        is excluding the set consisting of uppercase(65-90) & lowercase char(97-122)
        */
        return ((c >= 65 && c<91) || (c>=97 && c <123)) ? false: true;
    }

    public static boolean isNotLetters2(int c){
        /* same concept as above with logical equivalence version using DeMorgan's Law
        recall not(λ or β) ≡ not(λ) AND  not(β)

        Let λ = [A and B], let β = [C and D], thus
           not(λ or β)  => not([A and B] OR [C and D])
                        ≡ not[A and B] AND not[C and D]
                        ≡ not(A) or not(B) AND not(C) or not(D) ∎

                        ≡ [not(A) or not(B)] AND not(C) or not(D)∎ by Associative Law
                        ≡ not(A) or [not(B) AND not(C)] or not(D)∎ by Associative Law
                        ≡ not(A) or not(B) AND [not(C) or not(D)]∎ by Associative Law
        */
        return (c < 65 || c>=91 && c<97 || c >=123) ? true: false;
    }

    public static boolean isNotLetters3(int c){
        /*abstracted method*/
        return (!Character.isLetter(c))? true: false;
    }

    public static boolean isNotLetters4(int c){
        /*redundant but logically equivalent*/
        return (isNotLetters(c)|| isNotLetters2(c)|| isNotLetters3(c) || (!Character.isLetter(c)))? true: false;
    }

    public static String reverseOnlyLetters(String S) {
        StringBuilder str = new StringBuilder();
        HashMap<Integer, Character> specialCharsMap = new HashMap<>();
        char [] charArr = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        int cout = 0;

        for(int i = 0; i < charArr.length; i++){
            if(isNotLetters(charArr[i])){
                specialCharsMap.put(i, charArr[i]);
            }
            else{
                stack.push(charArr[i]);
            }
        }

        while(cout < S.length()){
            if(specialCharsMap.containsKey(cout)){
                str.append(specialCharsMap.get(cout));
            }
            else{
                str.append(stack.pop());
            }
            cout++;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(ReverseOnlyLetters.reverseOnlyLetters("ab-cd"));
        System.out.println(ReverseOnlyLetters.reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(ReverseOnlyLetters.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
        //ascii and unicode practice
//        Character c = 128;
//        System.out.println(Character.hashCode(c));
//        Character d = 'B' + 32;
//        System.out.println(d.hashCode());
//        System.out.println('\u270B');
//        System.out.println(isNotLetters(123));
//        System.out.println(isNotLetters2(123));
//        System.out.println(isNotLetters3(123));
//        System.out.println(isNotLetters4(123));
    }
}
