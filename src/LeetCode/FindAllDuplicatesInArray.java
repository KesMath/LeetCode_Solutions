package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindAllDuplicatesInArray {
    public static List<Integer> findDuplicates(int[] nums) {
        Arrays.sort(nums);
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i+1]){
                list.add(nums[i]);
            }
        }
        return list;
    }

    public static Integer[] toObject(int[] A) {
        Integer[] boxed = new Integer[A.length];
        for (int i = 0; i < A.length; i++) boxed[i] = Integer.valueOf(A[i]);
        return boxed;
    }

    public static List<Integer> findDuplicates1(int[] nums) {
        /**remove all elements appearing once
         * therefore leaving elements that appear twice
        **/
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] != nums[i+1]){
                nums[i] = 0;
            }
        }
        if(nums.length!=0)
            nums[nums.length-1] = 0;
        Arrays.sort(nums);

        int nonZeroIndex = 0;
        for(int i = nums.length - 1; i >=0; i--){
            if(nums[i]!=0){
                nonZeroIndex++;
            }
        }
        int [] duplicateArray = Arrays.copyOfRange(nums,
                nums.length - nonZeroIndex,
                nums.length);

        return Arrays.asList(toObject(duplicateArray));
    }

    public static void main(String[] args) {
        System.out.println(FindAllDuplicatesInArray.
                findDuplicates1(new int[]{4,3,2,7,8,2,3,1}));
    }
}
