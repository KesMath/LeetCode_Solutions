package LeetCode;

public class SmallerNumbersThanCurrent {
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] resultArr = new int[nums.length];
        int counter = 0;
        for(int i = 0; i <nums.length; i++){
            for(int j = 0; j <nums.length; j++){
                if(nums[i] > nums[j]){
                    counter++;
                }
            }
            resultArr[i] = counter;
            counter = 0;
        }
        return resultArr;
    }

    public static void main(String[] args) {
        int [] arr = {8,1,2,2,3}; //[4,0,1,1,3]
        int [] result = SmallerNumbersThanCurrent.smallerNumbersThanCurrent(arr);
        for(int e : result){
            System.out.println(e);
        }
    }
}

//"a1b2e"
//2^3 - 1 = 7
//Abe, aBe, abE,
//ABe, aBE, AbE, ABE
