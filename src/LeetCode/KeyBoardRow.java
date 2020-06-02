package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;

public class KeyBoardRow {
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;

    public static boolean isWordOfSameKeyRow(String str){
        boolean isSameKeyRow = true;
        char [] chararray = str.toLowerCase().toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('q',ONE);
        map.put('w',ONE);
        map.put('e',ONE);
        map.put('r',ONE);
        map.put('t',ONE);
        map.put('y',ONE);
        map.put('u',ONE);
        map.put('i',ONE);
        map.put('o',ONE);
        map.put('p',ONE);
        map.put('a',TWO);
        map.put('s',TWO);
        map.put('d',TWO);
        map.put('f',TWO);
        map.put('g',TWO);
        map.put('h',TWO);
        map.put('j',TWO);
        map.put('k',TWO);
        map.put('l',TWO);
        map.put('z',THREE);
        map.put('x',THREE);
        map.put('c',THREE);
        map.put('v',THREE);
        map.put('b',THREE);
        map.put('n',THREE);
        map.put('m',THREE);

        int keyRow = map.get(chararray[0]);
        for(int i = 1; i<chararray.length; i++){
            if(keyRow == map.get(chararray[i])){
                keyRow = map.get(chararray[i]);
            }
            else{
                isSameKeyRow = false;
                break;
            }
        }
        return isSameKeyRow;
    }

    public static String[] findWords(String[] words) {
        LinkedList<String> list = new LinkedList<>();
        for(String word : words){
            if(isWordOfSameKeyRow(word)){
                list.add(word);
            }
        }
        String [] arr = new String[list.size()];
        return list.toArray(arr);
    }

    public static void main(String[] args) {
        String [] words = {"Hello", "Alaska", "Dad", "Peace"};
        String [] filteredWords = KeyBoardRow.findWords(words);

    }
}
