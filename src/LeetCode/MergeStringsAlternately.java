package LeetCode;

import java.util.LinkedList;

public class MergeStringsAlternately {

    public static LinkedList<Character> merge(String word1, String word2, int index){
        LinkedList<Character> list = new LinkedList<>();
        char[] arr = word1.toCharArray();
        for(int i = 0; i < arr.length; i++){ list.add(arr[i]);}
        for(int i = 0; i < word2.length(); i++){
            list.add(index, word2.charAt(i));
            index+=2;
        }
        return list;
    }

    public static String mergeAlternately(String word1, String word2) {
        LinkedList<Character> list;
        if(word1.length() > word2.length()){
            list = merge(word1, word2, 1);
        }
        else if(word1.length() < word2.length()){
            list = merge(word2, word1, 0);
        }
        else{
            list = merge(word2, word1, 0);
        }
        StringBuilder s = new StringBuilder();
        for(int i=0; i<list.size(); i++)
            s.append(list.get(i));
        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(MergeStringsAlternately.
                            mergeAlternately("abc","pqr"));

        System.out.println(MergeStringsAlternately.
                mergeAlternately("ab","pqrs"));

        System.out.println(MergeStringsAlternately.
                mergeAlternately("abcd","pq"));
    }
}
