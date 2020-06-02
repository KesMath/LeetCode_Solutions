package LeetCode;

public class HouseRobber {

    public static int accum(int[] arr, int starting_index, int increment){
        int result = 0;
        if (starting_index >= 0 && increment > 0){
            for (int i = starting_index; i < arr.length; i += increment) {
                result += arr[i];
            }
        }
        return result;
    }

    public static int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        else if(nums.length == 2){
            if(nums[0] == nums[1]){
                return nums[0];
            }
        }
        int path1 = accum(nums,0,2);
        int path2 = accum(nums, 1,2);

        //checking endcaps as a potential max soln
        if(path1 == path2 && nums.length>0){
            if(nums[0] == nums[1])
                return nums[0] + nums[nums.length-1];
        }
        return (path1 >= path2) ? path1: path2;
    }

    public static void main(String[] args) {
        int [] arrays0 = {1,2,3,1};
        int [] arrays1 = {1,2};
        int [] arrays2 = {2,7,9,3,1};
        System.out.println(HouseRobber.rob(arrays0));
    }
}
