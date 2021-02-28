package LeetCode;

import java.util.Arrays;

public class AverageSalaryExcludingMinAndMax {

    public static double average(int[] salary) {
        double sum = 0.0;
        Arrays.sort(salary);
        for(int i = 1; i < salary.length - 1; i++) sum+=salary[i];
        return sum/(salary.length - 2);
    }

    public static int getMin(int[] A){
        int min = A[0];
        for(int i = 1; i < A.length; i++){
            if(A[i] < min){
                min = A[i];
            }
        }
        return min;
    }

    public static int getMax(int[] A){
        int max = A[0];
        for(int i = 1; i < A.length; i++){
            if(A[i] > max){
                max = A[i];
            }
        }
        return max;
    }

    public static double average1(int[] salary) {
        //non-sort approach!
        double sum = 0.0;
        int min = getMin(salary);
        int max = getMax(salary);
        for(int i = 0; i < salary.length; i++){
            if(salary[i] != max && salary[i] != min)
                sum+=salary[i];
        }
        return sum/(salary.length - 2);
    }

    public static void main(String[] args) {
        System.out.println(
                AverageSalaryExcludingMinAndMax.
                        average1(new int[]{4000,3000,1000,2000})
        );
    }
}
