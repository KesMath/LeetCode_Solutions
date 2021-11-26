package LeetCode;
import java.util.HashMap;

/**
 * DESCRIPTION: https://leetcode.com/problems/dot-product-of-two-sparse-vectors/
 * Given the definition of a sparse vector (which mostly contains zero values)
 * one can rely on a hashmap where key = index of non-zero integer & value = nums[i]
 * Simply put it, the hashmap would only store indices and values of non-zero terms which are the only crucial
 * values needed to compute a dot product.
 *
 * Then when you go to compute dot product you can employ this technique:
 * iterate though one hashmap, and if that key/index exists in the other hashmap,
 * perform dot product. The key of HASH1 NOT existing in HASH2 implies that a zero was in that position
 * thus we are avoiding wasted computation (due to Zero Property of Multiplication where 0*a = 0)
 */
public class SparseVector {

    private HashMap<Integer, Integer> nonZeroVector;

    public SparseVector(int[] nums) {
        this.nonZeroVector = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                this.nonZeroVector.put(i, nums[i]);
            }
        }
    }

    public int dotProduct(SparseVector vec) {

    }

    public static void main(String[] args) {
        SparseVector v1 = new SparseVector(new int[] {1,0,0,2,3});
        SparseVector v2 = new SparseVector(new int[] {0,3,0,4,0});
        System.out.println(v1.dotProduct(v2));
    }
}
