package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class ExcelSheet {
    //TODO: based on the first string, it will identify to us what multiple of 26 to multiply by
    //TODO: i.e. 'BB' is 26*2 + 2 = 54 & 'ZY' is 26*26 + 25 = 701
    //TODO: create a <Char, Int> hashmap where the int will identify some multiple of 26 based on first char
    //TODO: then add on integer key based on second char
    static char [] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J','K','L', 'M',
                              'N', 'O', 'P','Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static int titleToNumber(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int letterIndex;
        int numberMapping = 0;
        for(int i = 0; i < letters.length; i++){
            letterIndex = i + 1;
            map.put(letters[i], letterIndex);
        }

        if(s.length() == 1){
            return map.get(s.charAt(0));
        }

        /**
        start rightwards and make way towards left i.e.
        'AAA': 'A' = 1 thus 'AA' = (26*1)+1 = 27 thus 'AAA' = (26*26)+27 = 703
        'ZZZ': 'Z' = 26 thus 'ZZ' = (26*26)+26 = 702 thus 'ZZZ' = (26*26)+702 = 1378
        'AAAA': 'A' = 1 thus 'AA' = 26*1+1 = 27 thus 'AAA' = 26*26+27 = 703 thus 'AAAA' = (26*26)+703 = 1379

        OBSERVATION: the integer from the leftmost char is used to generate the integer from it's rightmost char
        having a recursive nature where the single char is the base case
         FORMULA = (26 * index or position of leftmost char) + index or position of rightmost char(s)
         **/
        //TODO: distinguish leftmost & rightmost cutoff for varying sizes of string
        return numberMapping;
    }

    public static void main(String[] args) {
        System.out.println(ExcelSheet.titleToNumber("ZZ"));
    }
}
