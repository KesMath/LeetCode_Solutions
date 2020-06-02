package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public final static int TARGET_OCCURRENCE = 1;

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int occurrences = 0;
        int result = 0;

        for(int i: nums){
            if(map.containsKey(i)){
                //System.out.println("Ith iteration inside if: " + i);
                int counter = map.get(i);
                counter++;
                //System.out.println("Counter val: " + counter);
                map.replace(i, counter);
            }
            else{
                //System.out.println("Ith iteration inside else: " + i);
                map.put(i, ++occurrences);
                occurrences = 0;
                //System.out.println(map);
            }
        }
        System.out.println(map);
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            //FIXME: solution only returns one value if occurrences of two integers are equivalent
            if(entry.getValue() == TARGET_OCCURRENCE){
                result = entry.getKey();
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] array = {4,1,2,1,2,1};
        System.out.println(SingleNumber.singleNumber(array));
    }
}
