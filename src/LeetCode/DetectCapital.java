package LeetCode;

public class DetectCapital {
//    Given a word, you need to judge whether the
//    usage of capitals in it is right or not.
//
//    We define the usage of capitals in a word to be
//    right when one of the following cases holds:
//
//    All letters in this word are capitals, like "USA".
//    All letters in this word are not capitals, like "leetcode".
//    Only the first letter in this word is capital, like "Google".

    public boolean isUpperCase(char c){
        //assuming c is a letter only!
        return (c>=65 && c <=90)? true : false;
    }

    public boolean detectCapitalUse(String word) {
        //THOUGHT PROCESS: if capital is detected elsewhere besides 0th index
        //and number of capital occurrences != string size, return false
        int cout = 0;
        for(int i = 0; i < word.length(); i++){
            if(isUpperCase(word.charAt(i))) cout++;
        }
        return (cout == word.length() || //implies word has all caps!
                (cout == 1  && isUpperCase(word.charAt(0))) || //implies only first char is uppercase!
                (cout == 0))? true: false; //implies all lowercase!
    }


    public static void main(String[] args) {
        DetectCapital d = new DetectCapital();
        System.out.println(d.detectCapitalUse("USA"));
        System.out.println(d.detectCapitalUse("FlaG"));
        System.out.println(d.detectCapitalUse("Google"));
        System.out.println(d.detectCapitalUse("leetcode"));
    }
}
