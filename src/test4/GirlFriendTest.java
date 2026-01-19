package test4;

import java.util.Scanner;

public class GirlFriendTest {
    public static void main(String[] args) {
        //定义数组存储4个女朋友的对象
        // 女朋友的属性:姓名、年龄、性别、爱好
        // 要求1:计算出四女朋友的平均年龄
        // 要求2:统计年龄比平均值低的女朋友有几个?并把她们的所有信息打印出来

        GirlFriend[] arr = new GirlFriend[4];

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            GirlFriend g = new GirlFriend();
            System.out.println("请输入姓名：");
            String name = sc.next();
            g.setName(name);
            System.out.println("请输入年龄：");
            int age = sc.nextInt();
            g.setAge(age);
            System.out.println("请输入性别：");
            String input = sc.next();
            char gender = input.charAt(0);
            g.setGender(gender);
            System.out.println("请输入爱好：");
            String hobby = sc.next();
            g.setHobby(hobby);
            arr[i] = g;
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            GirlFriend g = arr[i];
            sum = sum + g.getAge();
        }
        int avg = sum / arr.length;
        System.out.println("平均年龄为：" + avg);

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            GirlFriend g = arr[i];
            if (arr[i].getAge() < avg) {
                //g.showInfo();
                count++;
            }
        }
        System.out.println("年龄低于平均值的有" + count + "个，信息如下");

        for (int i = 0; i < arr.length; i++) {
            GirlFriend g = arr[i];
            if (arr[i].getAge() < avg) {
                g.showInfo();
            }
        }
    }
}
