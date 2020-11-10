package LeetCode;

import java.util.Arrays;

public class RunningSumOfArray {
    public static int[] runningSum(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum+=nums[i];
            nums[i] = sum;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(RunningSumOfArray.runningSum(new int[] {3,1,2,10,1})));
    }
}
