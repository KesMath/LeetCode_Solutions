package LeetCode;

import java.util.Arrays;
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

    public static int largestUniqueNumber1(int[] A) {
        //given A[i] <=1000 contraint,
        //thus freqArr[A[i]] == freqArr[1001] (due to zero based start index of arrays]
        int[] freqArr = new int[1001];
        int largestUniqueNum = -1;
        for(int i = 0; i < A.length; i++){ freqArr[A[i]]++;}
        for(int i = freqArr.length-1; i >=0; i--){
            if(freqArr[i]==1){
                largestUniqueNum = i;
                break;
            }
        }
        return largestUniqueNum;
    }

    public static void main(String[] args) {
        System.out.println(LargestUniqueNumber.largestUniqueNumber(new int[]{9,9,8,8}));
        System.out.println(LargestUniqueNumber.largestUniqueNumber(new int[]{5,7,3,9,4,9,8,3,1}));
        System.out.println("========================================");
        System.out.println(LargestUniqueNumber.largestUniqueNumber1(new int[]{9,9,8,8}));
        System.out.println(LargestUniqueNumber.largestUniqueNumber1(new int[]{5,7,3,9,4,9,8,3,1}));
    }
}
