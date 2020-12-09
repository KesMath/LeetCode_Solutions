package LeetCode;

import java.util.TreeMap;

public class LargestUniqueNumber {
    public static int largestUniqueNumber(int[] A) {
        int largestUniqueNumber = 0;
        TreeMap<Integer,Integer> treemap = new TreeMap<>();
        for(int i = 0; i < A.length; i++){
            if(treemap.containsKey(A[i])){
                treemap.put(A[i],treemap.get(A[i])+1);
            }
            else{
                treemap.put(A[i], 1);
            }
        }
        //iterating backwards in descending order to get largest value with occurrence = 1!
        Integer[] keySet = treemap.keySet().toArray(new Integer[treemap.size()]);
        for(int i = keySet.length-1; i >=0; i--){
            if(treemap.get(keySet[i]) == 1){
                largestUniqueNumber = keySet[i];
                break;
            }
            else{
                largestUniqueNumber = -1;
            }
        }
        return largestUniqueNumber;
    }

    public static void main(String[] args) {
        System.out.println(LargestUniqueNumber.largestUniqueNumber(new int[]{9,9,8,8}));
    }
}
