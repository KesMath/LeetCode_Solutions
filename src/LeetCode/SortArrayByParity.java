package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;

public class SortArrayByParity {
    public static boolean isEven(int n){
        return ((n % 2) == 0);
    }

    public static int[] sortArrayByParity(int[] A) {
        //no auxiliary data structures
        int[] evenArr, oddArr;
        int evenCounter = 0;
        for(int i = 0; i < A.length; i++){
           if(isEven(A[i])) {
               evenCounter++;
           }
        }
        evenArr = new int[evenCounter];
        oddArr = new int[A.length - evenCounter];
        for(int i = 0, j = 0, k = 0; i < A.length; i++){
            if(isEven(A[i])){
                evenArr[j] = A[i];
                j++;
            }
            else{
                oddArr[k] = A[i];
                k++;
            }
        }

        for(int i = 0, j = 0, k = 0; i < A.length; i++){
            if(j <= evenArr.length - 1 ){
                A[i] = evenArr[j];
                j++;
            }
            else{
                A[i] = oddArr[k];
                k++;
            }
        }
        return A;
    }

    public static int[] sortArrayByParity2(int[] A){
        //using auxiliary data structure
        LinkedList<Integer> evenList = new LinkedList<>();
        LinkedList<Integer> oddList = new LinkedList<>();
        for(int i = 0; i < A.length; i++){
            if(isEven(A[i])){
                evenList.add(A[i]);
            }
            else{
                oddList.add(A[i]);
            }
        }
        evenList.addAll(oddList);

        int[] paritySortedArray = new int[evenList.size()];
        int cout = 0;
        while(!evenList.isEmpty()){
            paritySortedArray[cout] = evenList.remove();
            cout++;
        }
        return paritySortedArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(SortArrayByParity.sortArrayByParity2(new int[] {3,1,2,4})));
        System.out.println(Arrays.toString(SortArrayByParity.sortArrayByParity(new int[] {3,1,2,4})));
    }
}
