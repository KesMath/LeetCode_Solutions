package LeetCode;

import java.util.HashMap;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                Integer val = map.get(nums[i]);
                val++;
                map.replace(nums[i], val);
            }
            else{
                map.put(nums[i],1);
            }
        }
        int tempMax = 0;
        int majorityElement = 0;
        for (Integer num: map.keySet()){
            if(map.get(num) > tempMax) {
                tempMax = map.get(num);
                majorityElement = num;
            }
        }
        return majorityElement;
    }

    public static void main(String[] args) {
        int [] arr = {2,2,1,1,1,1,2,2};
        System.out.println(MajorityElement.majorityElement(arr));
    }
}
