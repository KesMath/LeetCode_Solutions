package LeetCode;

import java.util.Arrays;

public class MaximumProduct {
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length-1] * nums[nums.length-2] * nums[nums.length-3];
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,4};
        int [] nums1 = {4444, 2, 1, -1, -10000, -4, 55, 77};
        System.out.println(MaximumProduct.maximumProduct(nums1));
    }
}
