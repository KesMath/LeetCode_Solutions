package LeetCode;

import java.util.Arrays;

public class SentencePangram {

    public static boolean checkIfPangram(String sentence) {
        boolean isPangram = true;
        int[] arr = new int[26];

        for(int i = 0; i < sentence.length(); i++){
            arr[sentence.charAt(i) - 97]++;
        }

        for (int i : arr){
            if(i == 0){
                isPangram = false;
                break;
            }
        }
        return isPangram;
    }

    public static void main(String[] args) {
        System.out.println(SentencePangram.checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(SentencePangram.checkIfPangram("leetcode"));
    }
}
