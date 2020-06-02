package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class ArrayIntersection {
    public static int[] intersect(int[] nums1, int[] nums2) {
        HashSet<Integer> setNum1 = new HashSet<>();
        HashSet<Integer> setNum2 = new HashSet<>();
        LinkedList<Integer> linkList = new LinkedList<>();

        for(int i = 0; i < nums1.length; i++){
            setNum1.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++){
            setNum2.add(nums2[i]);
        }

        for(Integer num: setNum1){
            if (setNum2.contains(num)){
                linkList.add(num);
            }
        }
        int[] arr = new int[linkList.size()];

        for(int i = 0; i<linkList.size(); i++){
            arr[i] = linkList.remove();
        }

        return arr;

    }


//public static int[] intersect(int[] nums1, int[] nums2) {
//    HashMap<Integer, Integer> intersectionMap = new HashMap<>();
//    LinkedList<Integer> result = new LinkedList<>();
//    boolean isNums1InHashmap = false;
//    int arrayInitializer = 0;
//
//    //load larger one into hashmap so second for loop can iterate less
//    if (nums1.length <= nums2.length){
//        for (int i = 0; i < nums2.length; i++){
//            intersectionMap.put(nums2[i],0);
//        }
//    }
//    else{
//        isNums1InHashmap = true;
//        for (int i = 0; i < nums1.length; i++){
//            intersectionMap.put(nums1[i],0);
//        }
//    }
//    if(isNums1InHashmap){
//        for(int i = 0; i < nums2.length; i++){
//            if (intersectionMap.get(nums2[i]) != null){
//                arrayInitializer++;
//                result.add(nums2[i]);
//            }
//        }
//    }
//    else{
//        for(int i = 0; i < nums1.length; i++){
//            if (intersectionMap.get(nums1[i]) != null){
//                arrayInitializer++;
//                result.add(nums1[i]);
//            }
//        }
//    }
//    int [] resultArray = new int[arrayInitializer];
//
//    for (int i = 0; i < arrayInitializer; i++){
//        resultArray[i] = result.remove();
//    }
//    return resultArray;
//}

    public static void main(String[] args) {
        int [] nums2 = {1,2,2,1};
        int [] nums1 = {2,2};
        System.out.println(Arrays.toString(ArrayIntersection.intersect(nums1,nums2)));
    }
}
