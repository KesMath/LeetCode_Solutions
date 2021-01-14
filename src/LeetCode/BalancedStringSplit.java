package LeetCode;

public class BalancedStringSplit {

    public static int balancedStringSplit(String s) {
        int ans = 0, lCout = 0, rCout = 0;
        /** traverse through string and count A = occur(R) and B = occur(L)
         * when they equal each other, increment ans and reset A & B
         */
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 'R') rCout++;
            else if(arr[i] == 'L') lCout++;
            if(lCout == rCout){
                ans++;
                lCout = 0;
                rCout = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(BalancedStringSplit.balancedStringSplit("RLLLLRRRLR"));
        System.out.println(BalancedStringSplit.balancedStringSplit("RLRRLLRLRL"));
        System.out.println(BalancedStringSplit.balancedStringSplit("LLLLRRRR"));
    }
}
