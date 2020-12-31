package LeetCode;

import java.util.Arrays;

public class ShortestDistanceToCharacter {

    public static int[] shortestToChar(String S, char C) {
        /** for each character in S, we traverse leftwards and rightwards
         * until C is met. Then we take the min of those two distances
         */
        char[] charArr = S.toCharArray();
        int[] distanceArr = new int[charArr.length];
        for(int i = 0; i < charArr.length; i++){
            if(charArr[i] == C){
                distanceArr[i] = 0;
            }
            else{
                int rightwardsDist = 0, leftwardsDist = 0;
                for(int j = i; j < charArr.length; j++){
                    if(charArr[j] == C){
                        rightwardsDist = j-i;
                        break;
                    }
                }
                for(int k = i; k >= 0 ; k--){
                    if(charArr[k] == C){
                        leftwardsDist = i-k;
                        break;
                    }
                }
                //math.max(A,B) if either dist == 0 implying C is found in one direction
                // else math.min(A,B) implying both directions found C
                if(rightwardsDist == 0 || leftwardsDist == 0){
                    distanceArr[i] = Math.max(rightwardsDist, leftwardsDist);
                }
                else{
                    distanceArr[i] = Math.min(rightwardsDist, leftwardsDist);
                }
            }
        }
        return distanceArr;
    }

    public static int[] shortestToChar1(String S, char C) {
        /**this approach transverses through each character in S
         * if character == C, just append 0 distance to integer arr.
         * else, [assuming iteration of loop != 0 or != len(S)] we shall create 2 substrings:
         * one for characters from index: 0 -> indexOf(character)-1 (call this substring A)
         * one for characters from index: indexOf(character)+1 -> len(array) (call this substring B)
         * Then we simply append to the integer array (Math.min(A.reverse().indexOf(C),B.indexOf(C)))
         *
         * (***NOTE: substring A needs to be reversed so indexOf() fetches
         * the shortest distance of C from right to left!
         * If it wasn't reversed, the method will return the farthest occurrence
         * which will be the longest distance!***)
         **/
        char[] charArr = S.toCharArray();
        int[] distanceArr = new int[charArr.length];

        for(int i = 0; i < charArr.length; i++){
            if(charArr[i] == C){
                distanceArr[i] = 0;
            }
            else{
                if(i == 0) {
                    distanceArr[i] = S.indexOf(C);
                }
                else if(i == charArr.length - 1) {
                    //TODO: when creating substring, we need to get index w.r.t original String!!!
                    distanceArr[i] = i - new StringBuilder(S.substring(0,i)).reverse().indexOf(""+C);
                }
                else{
                    //TODO: when creating substring, we need to get index w.r.t original String!!!
                    //TODO: Math.min should be called only when results are greater than 0
                    distanceArr[i] = i - Math.min(new StringBuilder(S.substring(0,i)).reverse().indexOf(""+C),
                            S.substring(i+1,charArr.length).indexOf(C));
                }
            }
        }
        return distanceArr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                ShortestDistanceToCharacter.shortestToChar("loveleetcode",'t')));

    }
}