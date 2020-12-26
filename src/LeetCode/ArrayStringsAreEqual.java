package LeetCode;

public class ArrayStringsAreEqual {
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        for(String word: word1){str1.append(word);}
        for(String word: word2){str2.append(word);}
        return str1.toString().equals(str2.toString());
    }

    public static boolean arrayStringsAreEqual1(String[] word1, String[] word2){
        //character expansion approach for memory efficiency
        int charArrSize = 0;
        for(int i = 0; i < word1.length;i++){
            charArrSize+=word1[i].length();
        }
        char[] charArr = new char[charArrSize];

        for(int i = 0, index = 0; i < word1.length; i++){
            for(int j = 0; j < word1[i].length(); j++){
                charArr[index] = word1[i].charAt(j);
                index++;
            }
        }
        //-------- character expansion for word2 --------
        int charArrSize2 = 0;
        for(int i = 0; i < word2.length;i++){
            charArrSize2+=word2[i].length();
        }
        char[] charArr2 = new char[charArrSize2];

        for(int i = 0, index = 0; i < word2.length; i++){
            for(int j = 0; j < word2[i].length(); j++){
                charArr2[index] = word2[i].charAt(j);
                index++;
            }
        }
        //---------------------------------------
        if(charArr.length != charArr2.length){
            return false;
        }
        else{
            for(int i = 0; i < charArr.length; i++){
                if(charArr[i] != charArr2[i]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(ArrayStringsAreEqual.arrayStringsAreEqual1(new String[]{"abc", "d", "defg"}, new String[]{"abcddefg"}));
        System.out.println(ArrayStringsAreEqual.arrayStringsAreEqual1(new String[]{"ab", "c"}, new String[]{"a", "bc"}));
        System.out.println(ArrayStringsAreEqual.arrayStringsAreEqual1(new String[]{"a", "cb"}, new String[]{"ab", "c"}));
    }
}
