package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class MaxConsecutiveOnes {
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

    public static void main(String[] args) {
        System.out.println(MaxConsecutiveOnes.findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
        System.out.println(MaxConsecutiveOnes.findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));
    }
}
