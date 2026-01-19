import java.util.Scanner;

public class SingingMatch {
    public static void main(String[] args) {
        //在唱歌比赛中，有6名评委给选手打分，分数范围是[0-100]之间的整数。
        //选手的最后得分为:去掉最高分、最低分后的4个评委的平均分，请完成上述过程并计算出选手的得分。

        int[] arr = new int[6];
        score(arr);
        int maxScore = getMax(arr);
        int minScore = getMin(arr);
        int sumScore = getSum(arr);
        int finalScore = (sumScore - maxScore - minScore) / (arr.length - 2);
        System.out.println("最终得分:" + finalScore);
    }

    //录入6个评委的打分
    public static int[] score(int[] arr) {

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; ) {  //这里for循环的条件放到了里面，满足条件再++
            System.out.println("请输入分数：");
            int score = sc.nextInt();
            if (score >= 0 && score <= 100) {
                arr[i] = score;
                i++;   //满足条件才++
            } else {
                System.out.println("数据有误，请重新输入");
            }
        }
        return arr;
    }

    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    public static int getMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    public static int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }


}
