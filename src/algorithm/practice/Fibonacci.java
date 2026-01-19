package algorithm.practice;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(12));
    }

    private static int fib(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }
        return fib(num - 1) + fib(num - 2);
    }

}
