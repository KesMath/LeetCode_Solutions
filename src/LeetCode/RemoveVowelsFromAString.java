package LeetCode;

import java.util.HashSet;

public class RemoveVowelsFromAString {
    private HashSet<Character> vowel;

    public RemoveVowelsFromAString(){
        this.vowel = new HashSet();
        this.vowel.add('a');
        this.vowel.add('e');
        this.vowel.add('i');
        this.vowel.add('o');
        this.vowel.add('u');
    }
    public String removeVowels(String S) {
        char[] charArr = S.toCharArray();
        StringBuilder s = new StringBuilder();
        for(char c : charArr){
            if(!this.vowel.contains(c))
                s.append(c);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        RemoveVowelsFromAString r = new RemoveVowelsFromAString();
        String s = "ltcdscmmntyfrcdrs";
        System.out.println(s.equals(r.removeVowels("leetcodeisacommunityforcoders")));
    }
}
