package LeetCode;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int zeroCount = 0;
        int countNum = countOccurrence(nums, 0);
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == 0){
                zeroCount++;
                int swapAmount = nums.length - i; //compute distance from that index to the end then swap "distance" times
                for(int j = 1, k = i; j < swapAmount; j++, k++) { // we need to track i and increment forward without changing the value of i ... hence we introduce k
                    swapAdjacentElements(nums, k, k+1);
                }
                if(zeroCount == countNum) //break early when all zeroes are moved!
                    break;
            }
        }
    }

    public static void swapAdjacentElements(int[] array, int index1, int index2){
        /*if adjacent elements are equal,
         *function will swap with the next, rightmost non-equal value!
         */
        if(index2 - index1 == 1) {
            if (array[index1] != array[index2]) {
                swap(array, index1, index2);
            } else {
                int cacheIndex2Value = array[index2];
                for (; index2 < array.length; index2++) {
                    if (array[index2] != cacheIndex2Value) {
                        break;
                    }
                }
                swap(array, index1, index2);
            }
        }
    }

    public static void swap(int[] array, int index1, int index2){
        if((index1 >= 0 && index1 < array.length) && (index2 >= 0 && index2 < array.length)) {
            int temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }
    }

    public static int countOccurrence(int[] array, int target){
        int counter = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] == target){
                counter++;
            }
        }
        return counter;
    }
    public static void main(String[] args) {
        /*
        Input:  [0,1,0,3,12]
        Output: [1,3,12,0,0]
        */
        int [] arr = {4,1,0,14,0};
        MoveZeroes.moveZeroes(arr);
        for (int elem: arr){
            System.out.println(elem);
        }
    }

}
