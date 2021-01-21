package LeetCode;

import java.util.Arrays;

public class SortArrayByParityII {
    public static int[] sortArrayByParityII(int[] A) {
        int [] oddArr = new int[A.length/2];
        int [] evenArr = new int[A.length/2];
        int oIndex = 0, eIndex = 0;

        for(int i = 0; i < A.length; i++){
            if(A[i] % 2 == 0){
                evenArr[eIndex] = A[i];
                eIndex++;
            }
            else{
                oddArr[oIndex] = A[i];
                oIndex++;
            }
        }
        for(int i = 0; i < A.length; i++){
            if(i % 2 == 0){
                A[i] = evenArr[--eIndex];
            }
            else{
                A[i] = oddArr[--oIndex];
            }
        }
        return A;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        SortArrayByParityII.
                                sortArrayByParityII(new int[]{4,2,5,7})
                                    ));
    }
}
