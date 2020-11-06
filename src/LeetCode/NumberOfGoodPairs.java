package LeetCode;

public class NumberOfGoodPairs {
    public static int numIdenticalPairs(int[] nums) {
        int identicalPairCounters = 0;
        for(int i = 0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++) {
                if(nums[i] == nums[j]){
                    System.out.println("(" + i + "," + j + ")");
                    identicalPairCounters++;
                }
            }
        }
        return identicalPairCounters;
    }

    public static void main(String[] args) {
        System.out.println(NumberOfGoodPairs.numIdenticalPairs(new int[]{1,1,1,1}));
        System.out.println(NumberOfGoodPairs.numIdenticalPairs(new int[]{1,2,3,1,1,3}));
    }

}
