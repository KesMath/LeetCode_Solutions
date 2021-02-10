package LeetCode;

import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOfTwoArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        //TODO: refactor to add arrays directly into constructor
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        HashSet<Integer> garbageSet = new HashSet<>();
        for(int e : nums1){ set1.add(e);}
        for(int e : nums2){ set2.add(e);}

        /** on line 36, it was initally set1.remove(e) but this
         *  threw a ConcurrentModificationException so
         * in order to circumvent this, the approach was to populate
         * the "symmetric difference" into garbageSet
         * and remove those elements from set1 in subsequent loop
         */
        for(int e : set1){
            if(!set2.contains(e)){
                garbageSet.add(e);
            }
        }
        for(int e : garbageSet){ set1.remove(e); }

        Integer[] integerArr = set1.toArray(new Integer[set1.size()]);
        int[] arr = new int[integerArr.length];
        for(int i = 0; i < integerArr.length; i++){
            arr[i] = integerArr[i];
        }
        return arr;
    }

    public static int[] intersection2(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    set.add(nums1[i]);
                    break;
                }
            }
        }
        Integer[] integerArr = set.toArray(new Integer[set.size()]);
        int[] arr = new int[integerArr.length];
        for(int i = 0; i < integerArr.length; i++){
         arr[i] = integerArr[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                IntersectionOfTwoArrays.intersection(
                            new int[] {1,2,2,1},
                            new int[] {2,2}
                            )
                            )
                            );

        System.out.println(Arrays.toString(
                IntersectionOfTwoArrays.intersection(
                        new int[] {4,9,5},
                        new int[] {9,4,9,8,4}
                )
                )
        );

    }
}
