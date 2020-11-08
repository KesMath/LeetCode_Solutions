package LeetCode;

public class MatrixDiagonalSum {
    public static int diagonalSum(int[][] mat) {
        /*
        two-pointer approach per row in matrix
        rather than having to iterate on primary and secondary diagonal
         */
        int sum = 0;
        int j = 0, k = mat.length - 1;
        for(int i = 0; i < mat.length; i++){
            for(; j == i; j++, k--){
                if(j != k){
                    sum += mat[i][j] + mat[i][k];
                }
                else {
                    sum += mat[i][j];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int [][] arr1 = {{1,2,3},
                         {4,5,6},
                         {7,8,9}};

        int [][] arr2 = {{1,1,1,1},
                         {1,1,1,1},
                         {1,1,1,1},
                         {1,1,1,1}};

        int [][] arr3 = {{5}};

        System.out.println(MatrixDiagonalSum.diagonalSum(arr1));
        System.out.println(MatrixDiagonalSum.diagonalSum(arr2));
        System.out.println(MatrixDiagonalSum.diagonalSum(arr3));
    }
}
