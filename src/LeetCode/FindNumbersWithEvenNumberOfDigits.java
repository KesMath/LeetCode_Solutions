package LeetCode;

public class FindNumbersWithEvenNumberOfDigits {
    public static int findNumbers(int[] nums) {
        int counter = 0;
        for(int i = 0; i < nums.length; i++){
            if (nums[i] >= 10 && nums[i] <= 9.9 * 10){counter++;}
            else if (nums[i] >= 1000 && nums[i] <= 9.999 * 1000){counter++;}
            else if (nums[i] >= 100000 && nums[i] <= 9.99999 * 100000){counter++;}
        }
        return counter;
    }

    public static void main(String[] args) {
        int [] nums = {555,901,482,1771};
        System.out.println(FindNumbersWithEvenNumberOfDigits.findNumbers(nums));
    }
}
