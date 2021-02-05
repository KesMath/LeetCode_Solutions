package LeetCode;

public class ElementAppearingMoreThanQuarterPercent {
    public static int findSpecialInteger(int[] arr) {
        //O(1) space approach!
        /**TODO: this approach slightly suffers in performance
         * by double checking the same arr[j] & arr[j+1]
         * twice which can be resolved by letting i get assigned to
         * the "inner runner" variable ... namely j!
         */
        int threshold = arr.length/4, cout = 1, specialInt = 0;
        for(int i = 0; i < arr.length; i++){
            int j = i;
            while(j + 1 < arr.length && arr[j] == arr[j+1]){
                cout++;
                j++;
            }
            if(cout > threshold){
                specialInt = arr[j];
                break;
            }
            else{
                cout = 1;
            }
        }
        return specialInt;
    }

    public static void main(String[] args) {
//        System.out.println(ElementAppearingMoreThanQuarterPercent.
//                findSpecialInteger(new int[]{1,2,2,6,6,6,6,7,10}));
        System.out.println(ElementAppearingMoreThanQuarterPercent.
                findSpecialInteger(new int[]{1,1}));
    }
}
