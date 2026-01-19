package algorithm.practice;

public class Fibonacci2 {
    public static void main(String[] args) {
        //可爱的小明特别喜欢爬楼梯，他有的时候一次爬一个台阶，有的时候一次爬两个台阶。
        //如果这个楼梯有20个台阶，小明一共有多少种爬法呢?
        //f(20) = f(19)+f(18)
        //f(19) = f(18)+f(17)
        //....
        //f(3) = f(2)+f(1)
        //其中f(2) = 2,f(1)=1
        System.out.println(getNum(20));
    }

    private static int getNum(int num) {
        if (num == 1)
            return 1;
        if (num == 2)
            return 2;
        return getNum(num - 1) + getNum(num - 2);
    }
}
