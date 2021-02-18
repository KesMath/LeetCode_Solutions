package LeetCode;

import java.util.Arrays;
public class NRepeatedElementInSize2NArray {

    public static int repeatedNTimes(int[] A) {
        /**sliding window technique!
         * given sorted array, we iterate
         * through each i in A and do this comparison:
         * A[i] == A[i+n], (where n = (A.length/2) - 1)
         * (recall we need offset n by 1 because arrays are 0 based)
         * we break and return that A[i] value!
         *
         * This works because repeated elements in array
         * are contiguous to one another, hence jumping
         * or sliding n steps away will reveal the
         * element that is repeated n-times!
         * For any other element that's not repeated n times,
         * sliding n steps away will equate to another number!
         */
        int integer = -1;
        int n = (A.length/2) - 1;
        Arrays.sort(A);
        for(int i = 0; i < A.length; i++){
            if(A[i] == A[i+n]){
                integer = A[i];
                break;
            }
        }
        return integer;
    }

    public static void main(String[] args) {
        System.out.println(
                NRepeatedElementInSize2NArray.
                        repeatedNTimes(new int[]{1,2,3,3})
        );

        System.out.println(
                NRepeatedElementInSize2NArray.
                        repeatedNTimes(new int[]{2,1,2,5,3,2})
        );

        System.out.println(
                NRepeatedElementInSize2NArray.
                        repeatedNTimes(new int[]{5,1,5,2,5,3,5,4})
        );
    }
}
