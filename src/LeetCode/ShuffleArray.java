package LeetCode;
import java.util.Arrays;

public class ShuffleArray {
    public static int[] shuffle(int[] nums, int n) {
        int [] returnArr = new int [nums.length];
        for(int k = 0, i = 0; n <= nums.length - 1; k++, n++, i+=2){
            returnArr[i] = nums[k];
            returnArr[i+1] = nums[n];
        }
        return returnArr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(ShuffleArray.shuffle(new int[] {1,1,2,2}, 2)));
    }
}
