package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class demo1 {
    public static void main(String[] args) {
        //键盘录入一些1~100之间的整数，并添加到集合中。
        //直到集合中所有数据和超过200为止

        int sum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (sum <= 200) {
            System.out.println("请录入1~100之间的整数");
            String s = sc.nextLine();
            int i = Integer.parseInt(s);
            if (i < 1 || i > 100) {
                System.out.println("超出范围");
                continue;
            }
            //java底层会自动把int i 包装成Interger i
            list.add(i);
            sum = sum + i;
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) +
                    " ");
        }


    }
}
