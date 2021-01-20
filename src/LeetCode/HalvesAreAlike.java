package LeetCode;

import java.util.Arrays;
import java.util.HashSet;

public class HalvesAreAlike {
    private HashSet<Character> vowels;

    public HalvesAreAlike(){
        this.vowels = new HashSet<>(
                Arrays.asList('A','a',
                              'E','e',
                              'I','i',
                              'O','o',
                              'U','u'));
    }

    public boolean halvesAreAlike(String s) {
        String a = s.substring(0, s.length()/2);
        String b = s.substring(s.length()/2);
        int aCout = 0, bCout = 0;
        for(int i = 0; i < a.length(); i++){
           if(this.vowels.contains(a.charAt(i))) aCout++;
           if(this.vowels.contains(b.charAt(i))) bCout++;
        }
        return aCout == bCout;
    }

    public static void main(String[] args) {
        HalvesAreAlike h = new HalvesAreAlike();
        System.out.println(h.halvesAreAlike("book"));
        System.out.println(h.halvesAreAlike("textbook"));
        System.out.println(h.halvesAreAlike("MerryChristmas"));
        System.out.println(h.halvesAreAlike("AbCdEfGh"));
    }
}
