package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class MaxConsecutiveOnes {
    //INEFFICIENT!
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, freq = 0;
        int key = 1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length;i++){
            if(nums[i] == 1){
                freq++;
            }
            else{
              map.put(key,freq);
              key++;
              freq = 0;
            }
        }
        //when end of array is reached!
        map.put(key,freq);
        key++;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue() > max){
                max = entry.getValue();
            }
        }
        return max;
    }

    //OPTIMAL THAN ONE ABOVE!
    public static int findMaxConsecutiveOnes1(int[] nums) {
        int max = 0, freq = 0, key = 0;

        /**number of zeros or breaks in the list will equate
         * to how many key/value pairs needed for arr size
         * thus no need to instantiate array to contraint size!
         */
        int mapSize = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) mapSize++;
        }

        // list size must be n+1 to account for additional grouping
        int[] map = new int[mapSize+1];
        for(int i = 0; i < nums.length;i++){
            if(nums[i] == 1){
                freq++;
            }
            else{
                map[key]=freq;
                key++;
                freq = 0;
            }
        }
        //when end of array is reached!
        map[key]=freq;
        key++;
        for(int e: map){
            if(e > max){
                max = e;
            }
        }
        return max;
    }

    //TODO: fix bug! This implementation should yield the most efficient implementation!
    public static int findMaxConsecutiveOnes2(int[] nums){
        int max = 0, accum = 0;
        for(int i = 0; i < nums.length;i++) {
            if(nums[i] == 1){
                accum++;
            }
            else{
                if(accum > max){
                    max = accum;
                    accum = 0;
                }
            }
        }
        //when end of array is reached!
        if(accum > max) max = accum;
        return max;
    }

    public static void main(String[] args) {
        System.out.println("============IMPLEMENTATION 1============");
        System.out.println(MaxConsecutiveOnes.findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
        System.out.println(MaxConsecutiveOnes.findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));
        System.out.println("============IMPLEMENTATION 2============");
        System.out.println(MaxConsecutiveOnes.findMaxConsecutiveOnes1(new int[]{1,1,0,1,1,1}));
        System.out.println(MaxConsecutiveOnes.findMaxConsecutiveOnes1(new int[]{1,0,1,1,0,1}));
        System.out.println("============IMPLEMENTATION 3============");
        System.out.println(MaxConsecutiveOnes.findMaxConsecutiveOnes2(new int[]{1,1,0,1,1,1}));
        System.out.println(MaxConsecutiveOnes.findMaxConsecutiveOnes2(new int[]{1,0,1,1,0,1}));
    }
}
