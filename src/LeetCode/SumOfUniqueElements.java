package LeetCode;

public class SumOfUniqueElements {

    public static int sumOfUnique(int[] nums) {
        int sum = 0;
        int[] map = new int[101];
        for(int i = 0; i < nums.length; i++){
            map[nums[i]]++;
        }
        for(int i = 0; i < map.length; i++){
            if(map[i] == 1)
                sum+=i;

        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(SumOfUniqueElements.sumOfUnique(new int[]{1,2,3,2}));
        System.out.println(SumOfUniqueElements.sumOfUnique(new int[]{1,1,1,1,1}));
        System.out.println(SumOfUniqueElements.sumOfUnique(new int[]{1,2,3,4,5}));
    }
}
