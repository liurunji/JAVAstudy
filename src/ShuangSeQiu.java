import java.util.Random;
import java.util.Scanner;

public class ShuangSeQiu {
    public static void main(String[] args) {
        //投注号码由6个红色球号码和1个蓝色球号码组成。红色球号码从1-33中选择;蓝色球号码从1-16中选择。
        //1.生成中奖号码
        int[] prizeArr = new int[7];
        generateResult(prizeArr);
        for (int i = 0; i < prizeArr.length; i++) {
            System.out.print(prizeArr[i] + " ");
        }
        System.out.println("\n");
        //2.输入你的号码
        int[] yourArr = new int[7];
        yourNumber(yourArr);
        /*for (int i = 0; i < yourArr.length; i++) {
            System.out.print(yourArr[i] + " ");
        }*/

        //3.判定中奖情况
        int red = 0, blue = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (yourArr[i] == prizeArr[j]) {
                    red++;
                    break;
                }
            }
        }
        if (yourArr[6] == prizeArr[6])
            blue = 1;
        System.out.println(red);
        System.out.println(blue);
        //得到奖金
        int bonus = bonus(red, blue);
        System.out.println("你的奖金为" + bonus + "元");


    }

    //生成随机获奖号码
    public static int[] generateResult(int[] arr) {
        Random r = new Random();
        for (int i = 0; i < 6; ) {//生成红球号码
            int number = r.nextInt(33) + 1;
            if (!contains(arr, number)) {  //如果不存在那么才存入数组，继续往后循环
                arr[i] = number;
                i++;
            }
        }
        arr[6] = r.nextInt(16) + 1;  //生成蓝球号码
        return arr;
    }

    //确保不重复
    public static boolean contains(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number)
                return true; //存在返回true
        }
        return false;  //不存在返回false
    }

    //输入你的号码
    public static int[] yourNumber(int[] arr) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 6; ) {
            System.out.println("请输入第" + (i + 1) + "个红球号码");
            int number = sc.nextInt();
            boolean flag = contains(arr, number);
            //输入红球号码
            if (number >= 1 && number <= 33) {
                if (!flag) {
                    arr[i] = number;
                    i++;
                } else {
                    System.out.println("红球号码已存在请重新输入");
                }

            } else {
                System.out.println("红色球号码非法，请重新输入");
            }


        }
        //输入篮球号码

        while (true) {
            System.out.println("请输入蓝色球号码");
            int number = sc.nextInt();
            if (number >= 1 && number <= 16) {
                arr[6] = number;
                break;
            } else {
                System.out.println("蓝色球号码非法，请重新输入");
            }
        }

        return arr;
    }

    //判定中奖情况
    public static int bonus(int red, int blue) {
        int prize = 0;
        switch (red) {
            case 0:
                if (blue == 1) {
                    prize = 5;
                } else {
                    prize = 0;
                }
                break;
            case 1:
                if (blue == 1) {
                    prize = 5;
                } else {
                    prize = 0;
                }
                break;
            case 2:
                if (blue == 1) {
                    prize = 5;
                } else {
                    prize = 0;
                }
                break;
            case 3:
                if (blue == 1) {
                    prize = 10;
                } else {
                    prize = 0;
                }
                break;
            case 4:
                if (blue == 1) {
                    prize = 200;
                } else {
                    prize = 10;
                }
                break;
            case 5:
                if (blue == 1) {
                    prize = 3000;
                } else {
                    prize = 200;
                }
                break;
            case 6:
                if (blue == 1) {
                    prize = 10000000;
                } else {
                    prize = 5000000;
                }
                break;
        }
        return prize;
    }

}
