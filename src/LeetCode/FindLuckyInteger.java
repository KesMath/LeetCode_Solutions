package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class FindLuckyInteger {
    public static int findLucky(int[] arr) {
        int val = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }
            else{
                map.put(arr[i], 1);
            }
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(entry.getKey() == entry.getValue()){
                if(entry.getKey() > val)
                    val = entry.getKey();
            }
        }
            return val;
    }


    public static void main(String[] args) {
        System.out.println(FindLuckyInteger.findLucky(new int[]{2,2,3,4}));
        System.out.println(FindLuckyInteger.findLucky(new int[]{1,2,2,3,3,3}));
        System.out.println(FindLuckyInteger.findLucky(new int[]{2,2,2,3,3}));
    }
}
