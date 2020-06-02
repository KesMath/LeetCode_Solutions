package LeetCode;

import java.util.HashMap;

public class FirstUniqueChar {
    public static int firstUniqChar(String s) {
        char[] charArr = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int result = -1;
        for(int i = 0; i < charArr.length; i++){
            if(map.containsKey(charArr[i])){map.replace(charArr[i], map.get(charArr[i]) + 1);}
            else{map.put(charArr[i],1);}
        }

        for(int i = 0; i < charArr.length; i++){
            if(map.get(charArr[i]) == 1){
                result = i;
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String s = "lloovvee";
        System.out.println(FirstUniqueChar.firstUniqChar(s));
    }


}
