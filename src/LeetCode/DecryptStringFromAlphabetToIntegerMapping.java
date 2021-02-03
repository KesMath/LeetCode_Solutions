package LeetCode;

import java.util.HashMap;

public class DecryptStringFromAlphabetToIntegerMapping {
    public static String freqAlphabets(String s) {
        /*convert S to char array and iterate backwards
        if s[i] == '#' build a string with: s[i-2] + s[i-1]
        then do a lookup in dict, flush stringbuilder object and decrement iterator by 2 and proceed
        else:
        just do normal lookup with String.valueOf(s[i])
         */
        char[] arr = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder tempbuilder = new StringBuilder();
        HashMap<String, Character> map = new HashMap<>();
        char initChar = 'a';
        for(int i = 1; i < 27; i++){
            map.put(Integer.toString(i), (char)(initChar));
            initChar+=1;
        }

        for(int i = arr.length-1; i >=0 ;i--){
            if(arr[i] == '#'){
                tempbuilder.append(arr[i-2]).append(arr[i-1]);
                stringBuilder.append(map.get(tempbuilder.toString()));
                tempbuilder.delete(0, tempbuilder.length()); //flush out object content so next iteration will not have lingering chars
                i-=2;
            }
            else{
                stringBuilder.append(map.get(String.valueOf(arr[i])));
            }
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "10#11#12"; //jkab
        String s2 = "1326#"; //acz
        String s3 = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"; //acz
        String expected = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(DecryptStringFromAlphabetToIntegerMapping.freqAlphabets(s3).equals(expected));

    }
}
