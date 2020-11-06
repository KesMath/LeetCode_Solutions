package LeetCode;
import java.util.Arrays;
import java.util.LinkedList;

public class DecompressRunLengthEncodedList {
    public static int[] decompressRLElist(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < nums.length; i+=2){
            int valIndex = i + 1;
            while (nums[i] != 0){
                list.add(nums[valIndex]);
                nums[i]--;
            }
        }
        int[] arr = new int[list.size()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = list.remove();
        }
        return arr;
    }

//    public static int[] decompressRLElist1(int[] nums) {
//        int [] freqArr = new int[nums.length/2];
//        int [] valArr = new int[nums.length/2];
//        int returnArrSize = 0;
//        for (int i = 0; i < freqArr.length; i++){ freqArr[i] = nums[i+=2]; }
//        for (int i = 0; i < valArr.length; i++){ valArr[i] = nums[i+=1]; }
//        for (int i = 0; i < freqArr.length; i++){returnArrSize += freqArr[i];}
//        int [] decompressedList = new int[returnArrSize];
//
//        for(int i = 0; i < freqArr.length; i++){
//            while(freqArr[i] != 0){
//                decompressedList[i] = valArr[i];
//                i--;
//            }
//        }
//        return decompressedList;
//
//    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(DecompressRunLengthEncodedList.decompressRLElist(new int[] {1,2,3,4})));
    }
}
