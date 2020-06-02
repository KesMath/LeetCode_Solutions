package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;

public class FindTheDifference {
    /* load into hashmap indexWithinS -> char... then get the entry from hashmap that has a key of -1
    / before insertion, if map.containsKey == True,
    then break and return that char.. that implies T has 2 identical char within S
    */
    public static char findTheDifference(String s, String t){
        HashMap<Integer, Character> map = new HashMap<>();

        for(int i = 0; i < t.length(); i++){
            int indexWithinS = s.indexOf(t.charAt(i));
            if(map.containsKey(indexWithinS)){
                return map.get(indexWithinS);
            }
            else{
                map.put(indexWithinS, t.charAt(i));
            }
        }
        return map.get(-1);
    }

    public static void main(String[] args) {
        String s = "a";
        String t = "aa";
        String u = "abcd";
        String v = "abcde";
        System.out.println(FindTheDifference.findTheDifference(u,v));
    }
}
