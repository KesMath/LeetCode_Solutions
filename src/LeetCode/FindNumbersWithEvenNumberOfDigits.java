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

    public int findNumbers1(int[] nums) {
        int cout = 0;
        for(int num : nums){
            if(Integer.toString(num).length() % 2 == 0)
                cout++;
        }
        return cout;

    }

    public static void main(String[] args) {
        int [] nums = {555,901,482,1771};
        System.out.println(FindNumbersWithEvenNumberOfDigits.findNumbers(nums));
    }
}
