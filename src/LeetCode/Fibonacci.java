package LeetCode;

public class Fibonacci {
    public static int fib(int n) {
        switch (n){
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return fib(n-1) + fib(n-2);
        }
    }
    public static int fib2(int n){
        int NthMinus1 = 0;
        int NthMinus2 = 1;
        switch (n){
            case 0:
                return NthMinus1;
            case 1:
                return NthMinus2;
            default:
                int FofN = 0;
                for(int i = 0; i <n; i++){
                    FofN = NthMinus1 + NthMinus2;
                    //need to reassign or shift terms so sequence can occur
                    NthMinus2 = NthMinus1;
                    NthMinus1 = FofN;
                }
                return FofN;
        }
    }

    public static int fib3(int n) {
        double goldenRatio = (1 + Math.sqrt(5)) / 2;
        return (int)Math.round(Math.pow(goldenRatio, n)/ Math.sqrt(5));
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci.fib(5));
        System.out.println(Fibonacci.fib2(5));
        System.out.println(Fibonacci.fib3(5));
        System.out.println(Math.pow(2,3));
    }
}
