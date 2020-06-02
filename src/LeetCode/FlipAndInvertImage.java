package LeetCode;

public class FlipAndInvertImage {
    public static int invertBit(int a){
        a = (a == 0) ? 1 : 0;
        return a;
    }
    public static boolean isOdd(int a){
        if(a % 2 == 1){
            return true;
        }
        return false;
    }
    public static int[][] flipAndInvertImage(int[][] A) {
        for(int i = 0; i < A.length; i++){
            boolean isOdd = isOdd(A.length); //given A is a non-jagged matrix, we can compute parity before inner for loop
            for(int j = A[i].length-1, k = 0; j >= A[i].length/2; j--,k++){
                int temp = A[i][j];
                A[i][j] = A[i][k];
                A[i][k] = temp;
                A[i][j] = invertBit(A[i][j]);
                /* In order to prevent double inversion on middle entry,
                 * if len of arr is odd and j == last iteration, do not do this inversion
                 * By Demorgan's Law, this is logically equivalent to:
                 * do inversion if len of arr is not odd or j != last iteration
                 */
                if(!isOdd || j != A[i].length/2)
                    A[i][k] = invertBit(A[i][k]);
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,1,0},{1,0,1},{0,0,0}};
        int[][] arr2 = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        FlipAndInvertImage.flipAndInvertImage(arr);
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.println(arr[i][j]);
            }
        }
    }
}
