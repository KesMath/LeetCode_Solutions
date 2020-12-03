package LeetCode;
import java.util.HashMap;
import java.util.TreeMap;

public class ShuffleString {
    public static String restoreString(String s, int[] indices) {
        char[] arr = s.toCharArray();
        StringBuilder str = new StringBuilder();
        HashMap<Integer, Character> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(indices[i], arr[i]);
        }
        for(int i = 0; i < map.size(); i++){
            str.append(map.get(i));
        }
        return str.toString();
    }

    public static String restoreString1(String s, int[] indices) {
        char[] arr = s.toCharArray();
        TreeMap<Integer, Character> sortedMap = new TreeMap<>();
        for(int i = 0; i < arr.length; i++){
            sortedMap.put(indices[i], arr[i]);
        }
        return sortedMap.values().toString().replace("[", "")
                                            .replace("]", "")
                                            .replace(", ","");
    }

    public static void main(String[] args) {
        System.out.println(ShuffleString.restoreString("codeleet", new int[] {4,5,6,7,0,2,1,3}));
        System.out.println(ShuffleString.restoreString("abc", new int[] {0,1,2}));
        System.out.println(ShuffleString.restoreString("aiohn", new int[] {3,1,4,2,0}));
        System.out.println(ShuffleString.restoreString("aaiougrt", new int[] {4,0,2,6,7,3,1,5}));
        System.out.println(ShuffleString.restoreString("art", new int[] {1,0,2}));
    }
}
