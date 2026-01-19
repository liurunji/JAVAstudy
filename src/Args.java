public class Args {
    /*
    可变参数
     */
    public static void main(String[] args) {
        System.out.println(getSum(1, 2, 3, 4, 5, 6, 7, 8));
        System.out.println(getSum2(1, 2, 3, 4, 5, 6, 7, 8));
    }

    public static int getSum(int... args) {
        int sum = 0;
        for (int i = 0; i < args.length; i++) {
            sum = sum + args[i];
        }
        return sum;
    }

    public static int getSum2(int... args) {
        int sum = 0;
        for (int num : args) {
            sum = sum + num;
        }
        return sum;
    }
}
