package LeetCode;
import java.util.Arrays;

/**
 * DESCRIPTION: https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
 */
public class ReplaceElementsWithGreatestElementOnRightSide {

    public static int[] replaceElements(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++){
            int max = 0;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] > max)
                    max = arr[j];
            }
            arr[i] = max;
        }
        arr[arr.length-1] = -1;
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                           ReplaceElementsWithGreatestElementOnRightSide.replaceElements(
                                   new int[]{17,18,5,4,6,1}
                                   )
                           )
        ); //returns: [18, 6, 6, 6, 1, -1]
    }
}
