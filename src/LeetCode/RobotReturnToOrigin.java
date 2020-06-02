package LeetCode;

import java.util.Arrays;

public class RobotReturnToOrigin {
    public static boolean judgeCircle(String moves) {
        int[] frequencyCount = new int[4];

        for(char move: moves.toCharArray()){
            switch (move){
                case 'U':
                    frequencyCount[0]++;
                    break;
                case 'D':
                    frequencyCount[1]++;
                    break;
                case 'L':
                    frequencyCount[2]++;
                    break;
                case 'R':
                    frequencyCount[3]++;
                    break;
            }
        }

        //having an equal number of opposite directions will assure robot will return back to origin
        if(frequencyCount[0] == frequencyCount[1] &&
                frequencyCount[2] == frequencyCount[3]){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(RobotReturnToOrigin.judgeCircle("UDLR"));
        System.out.println(RobotReturnToOrigin.judgeCircle("LL"));
    }
}
