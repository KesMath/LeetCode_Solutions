package LeetCode;

import java.util.Map;

public class MissingNumber {
    public static int missingNumber(int[] nums) {
        /**Since the length of the array indicates the highest number (recall we're iterating through 0,1,2,3,..,n)
        thus sum = 0 + 1 + 2 + 3 + ... + n using a loop or use Gauss Summation technique for 0(1) accumulation
        Suppose d is missing term (and a,b,c,etc. are elements in nums), then d = sum - (a+b+c) OR d = sum - a - b - c
         **/
        int sum = (nums.length * (nums.length+1))/2;
        for(int n: nums) sum -= n;
        return sum;
    }

    public static void main(String[] args) {
        int [] array = {9,6,4,2,3,5,7,0,1};
        System.out.println(MissingNumber.missingNumber(array));
    }
}
