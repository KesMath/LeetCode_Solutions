package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class UniqueNumberOfOccurrences {
    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> occurrenceMap = new HashMap<>();
        for(int e: arr){
            if(occurrenceMap.containsKey(e)){
                occurrenceMap.put(e, occurrenceMap.get(e)+1);
            }
            else{
                occurrenceMap.put(e,1);
            }
        }
        HashSet<Integer> set = new HashSet<>(occurrenceMap.values());
        return set.size() == occurrenceMap.size();
    }

    public static boolean uniqueOccurrences1(int[] arr) {
        boolean isUnique = true;
        LinkedList<Integer> list = new LinkedList<>();
        int cout = 1;
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        for(int i = 0; i < arr.length-1; i++){
            if(arr[i] == arr[i+1]){
                cout++;
            }
            else{
                list.add(cout);
                cout = 1;
            }
        }
        list.add(cout);
        Integer[] occurArr = list.toArray(new Integer[list.size()]);
        Arrays.sort(occurArr);
        for(int i = 0; i < occurArr.length-1; i++){
            if(occurArr[i] == occurArr[i+1]){
                isUnique = false;
                break;
            }
        }
        return isUnique;
    }


    public static void main(String[] args) {
        System.out.println(
                UniqueNumberOfOccurrences.
                        uniqueOccurrences(new int[]{1,2,2,1,1,3}));

        System.out.println(
                UniqueNumberOfOccurrences.
                        uniqueOccurrences(new int[]{1,2}));

        System.out.println(
                UniqueNumberOfOccurrences.
                        uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));


    }
}
