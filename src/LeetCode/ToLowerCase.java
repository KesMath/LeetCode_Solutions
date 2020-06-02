package LeetCode;

import java.util.HashMap;

public class ToLowerCase {
    public static String toLowerCase(String str) {
        StringBuilder builder = new StringBuilder();
        char[] charArr = str.toCharArray();
        HashMap<Character,Character> map = new HashMap<>();
        map.put('A','a');
        map.put('B','b');
        map.put('C','c');
        map.put('D','d');
        map.put('E','e');
        map.put('F','f');
        map.put('G','g');
        map.put('H','h');
        map.put('I','i');
        map.put('J','j');
        map.put('K','k');
        map.put('L','l');
        map.put('M','m');
        map.put('N','n');
        map.put('O','o');
        map.put('P','p');
        map.put('Q','q');
        map.put('R','r');
        map.put('S','s');
        map.put('T','t');
        map.put('U','u');
        map.put('V','v');
        map.put('W','w');
        map.put('X','x');
        map.put('Y','y');
        map.put('Z','z');

        for(int i = 0; i <= charArr.length-1; i++){
            if(map.containsKey(charArr[i])){
                builder.append(map.get(charArr[i]));
            }
            else{
                builder.append(charArr[i]);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(ToLowerCase.toLowerCase("LOVELY"));
        System.out.println(ToLowerCase.toLowerCase("Hello"));
        System.out.println(ToLowerCase.toLowerCase("here"));
    }
}
