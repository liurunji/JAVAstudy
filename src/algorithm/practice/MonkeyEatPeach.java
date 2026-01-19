package algorithm.practice;

import java.util.Arrays;

public class MonkeyEatPeach {
    public static void main(String[] args) {
        //有一堆桃子，猴子第一天吃了其中的一半，并多吃了一个!
        //以后每天猴子都吃当前剩下来的一半，然后再多吃一个，
        // 第10天的时候(还没吃)，发现只剩下一个桃子了，
        // 请问，最初总共多少个桃子?

        //方法一：数组迭代
        int[] arr = new int[10];
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = (arr[i - 1] + 1) * 2;
        }
        System.out.println(Arrays.toString(arr));


        //方法二：递归
        System.out.println(getPeaches(1));
    }

    public static int getPeaches(int day) {
        if (day <= 0 || day > 10) {
            return -1;
        }
        if (day == 10) {
            return 1;
        }
        return (getPeaches(day + 1) + 1) * 2;

    }
}
