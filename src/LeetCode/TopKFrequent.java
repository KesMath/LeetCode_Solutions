package LeetCode;
import java.util.Comparator;
import java.util.TreeMap;

//DESCRIPTION: https://leetcode.com/problems/top-k-frequent-elements/
public class TopKFrequent {

    public class ValueComparator implements Comparator<TreeMap>{

        @Override
        //for comparison to work, function needs the proper key compare values
        public int compare(TreeMap firstTreeMap, TreeMap secondTreeMap) {
            //return Integer.compare(firstTreeMap.get(), secondTreeMap.get());
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num : nums){
            if(!map.containsKey(num)){
                map.put(num, 1);
            }
            else{
                map.put(num, map.get(num)+1);
            }
        }
        // with this approach, we now have 1:3, 2:2, 3,1 but we need to sort the values in descending order
        // then we will be able to return those k frequent items
    }

    public static void main(String[] args) {
        System.out.println(TopKFrequent.topKFrequent(new int[] {1,1,1,2,2,3}, 2));
        System.out.println(TopKFrequent.topKFrequent(new int[] {1}, 1));
    }
}
