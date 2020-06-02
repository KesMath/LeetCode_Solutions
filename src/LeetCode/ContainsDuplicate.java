package LeetCode;

import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        int previousIterationSize = 0;
        boolean bool = false;

        //if size of set doesn't increase by one after adding, then a duplicate exists
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
            if(set.size() != previousIterationSize + 1){
                bool = true;
                break;
            }
            previousIterationSize = set.size();
        }
        return bool;
    }

    public static void main(String[] args) {
        int [] nums2 = {9,4,3,8,8};
        int [] nums1 = {9};
        System.out.println(ContainsDuplicate.containsDuplicate(nums2));
    }
}
