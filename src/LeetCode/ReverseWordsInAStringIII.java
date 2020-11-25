package LeetCode;

public class ReverseWordsInAStringIII {

    public static String reverseWord(String s){
        //two-pointer approach to string reverse
        char[] arr = s.toCharArray();
        StringBuilder b = new StringBuilder();
        for(int i = 0, j = arr.length-1; i <= (arr.length/2)-1; i++,j--){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return b.append(arr).toString();
    }

    public static String reverseWords(String s) {
        String [] strArr = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for(String str: strArr){
            builder.append(reverseWord(str) + " ");
        }
        return builder.toString().trim();
    }

    public static String reverseWords2(String s){
        StringBuilder globalBuilder = new StringBuilder();
        StringBuilder str = new StringBuilder();
        String [] strArr = s.split(" ");
        for(String ss: strArr){
            str.append(ss);
            str.reverse();
            globalBuilder.append(str + " ");
            str.delete(0, str.length());
        }
        return globalBuilder.toString().trim();
    }

    public static String reverseWords3(String s){
        StringBuilder globalBuilder = new StringBuilder();
        String [] strArr = s.split(" ");
        for(String ss: strArr){
            globalBuilder.append(new StringBuilder(ss).reverse() + " ");
        }
        return globalBuilder.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(ReverseWordsInAStringIII.reverseWords("Let's take LeetCode contest"));
        System.out.println(ReverseWordsInAStringIII.reverseWords2("Let's take LeetCode contest"));
        System.out.println(ReverseWordsInAStringIII.reverseWords3("Let's take LeetCode contest"));
        System.out.println(
                ReverseWordsInAStringIII.reverseWords2("Let's take LeetCode contest").
                        equals(ReverseWordsInAStringIII.reverseWords3("Let's take LeetCode contest")));

    }
}
