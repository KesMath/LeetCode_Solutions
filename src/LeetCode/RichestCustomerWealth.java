package LeetCode;

public class RichestCustomerWealth {
    public static int maximumWealth(int[][] accounts) {
        int max = 0;
        for(int i = 0; i < accounts.length; i++){
            int accum = 0;
            for(int j = 0; j < accounts[i].length; j++){
                accum+=accounts[i][j];
            }
            if(accum > max) max = accum;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(RichestCustomerWealth.maximumWealth(new int[][]{{2,8,7},
                                                                            {7,1,3},
                                                                            {1,9,5}}));
    }
}
