package LeetCode;

public class NumberOfStepsToZero {
    public static int numberOfSteps (int num) {
        int counter = 0;
        while(num != 0){
            if(num % 2 == 0){
                num >>= 1;
                counter++;
            }
            else {
                num -= 1;
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(NumberOfStepsToZero.numberOfSteps(123));
    }
}
