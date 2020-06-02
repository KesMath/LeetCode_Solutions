package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    //used to hold (index, difference) within dictionary
    class Tuple {
        int a;
        int b;

        public Tuple(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return this.a;
        }

        public int getB() {
            return this.b;
        }
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Tuple> storeDiff = new HashMap<Integer, Tuple>();
        int[] indexArr = new int[2];
        Tuple potentialTuple = null;
        Tuple diffTuple = null;

        for (int i = 0; i < nums.length; i++) {
            storeDiff.put(nums[i], new Tuple(i, target - nums[i]));
        }
        // now we can iterate through the dict and check if there's a double association:
        // (i.e. (target - entry) is also a key within dict hence proving both operands for target exists within array)
        // In other words:
        // t - e1 = r1
        // t - e2 = r2 (when r2 = e1 we have our soln since e1 + e2 =t)

        for (Integer key : storeDiff.keySet()) {
            potentialTuple = storeDiff.get(key);

            if (storeDiff.get(potentialTuple.getB()) != null) {
                diffTuple = storeDiff.get(potentialTuple.getB());
                break;
            }
        }

        indexArr[0] = potentialTuple.getA();
        indexArr[1] = diffTuple.getA();

        //implies duplicate entry...replacing duplicate entry with dummy value so array can fetch index of other duplicate entry
        if (indexArr[0] == indexArr[1]) {
            nums[potentialTuple.getA()] = -1;

            for (int j = 0; j < nums.length; j++) {
                if (potentialTuple.getB() == nums[j]) {
                    indexArr[0] = j;
                    break;
                }
            }
        }

        return indexArr;
    }

    public static void main(String[] args) {
        TwoSum problemSet = new TwoSum();
        int[] arr = new int[]{5, 6, 10, 43, 55, 77, 90};
        int val = 100;
        int[] arr2 = new int[]{3, 3};
        int val2 = 6;
        System.out.println(Arrays.toString(problemSet.twoSum(arr, val)));
    }
}