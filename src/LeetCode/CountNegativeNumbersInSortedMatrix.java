package LeetCode;

public class CountNegativeNumbersInSortedMatrix {
    public static int countNegatives(int[][] grid) {
        /** given matrix is sorted in non-increasing order both row-wise and column-wise,
         * starting from lower right hand corner, we can traverse rightwards
         * incrementing counter when cell is < 0. When cell > 0, loop is broken and
         * move to the (n-1) row!
         */
        int cout = 0;
        int rowPointerUpwards = grid.length-1;
        for(int i = grid.length-1; i >= 0; i--, rowPointerUpwards--){
            int colPointerFixed = grid[i].length-1;

            for(int j = grid[i].length-1; j>=0; j--){
                if(grid[rowPointerUpwards][colPointerFixed] < 0){
                    cout++;
                    colPointerFixed--;
                }
                else{
                    break;
                }
            }
        }
        return cout;
    }

    public static void main(String[] args) {
        int [][] grid = {{4,3,2,-1},
                         {3,2,1,-1},
                         {1,1,-1,-2},
                         {-1,-1,-2,-3}};

        int[][] grid2 = {{1,-1},
                         {-1,-1}};

        int[][] grid3 = {{-1}};
        int[][] grid4 = {{5,1,0},
                         {-5,-5,-5}};
        System.out.println(CountNegativeNumbersInSortedMatrix.countNegatives(grid));
        System.out.println(CountNegativeNumbersInSortedMatrix.countNegatives(grid2));
        System.out.println(CountNegativeNumbersInSortedMatrix.countNegatives(grid3));
        System.out.println(CountNegativeNumbersInSortedMatrix.countNegatives(grid4));

    }
}
