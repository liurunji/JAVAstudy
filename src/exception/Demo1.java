package exception;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        /*
        需求:
        键盘录入自己心仪的女朋友姓名和年龄。
        姓名的长度在3-10之间
        年龄的范围为18-40岁
        超出这个范围是异常数据不能赋值，需要重新录入,一直录到正确为止。
        提示:
        需要考虑用户在键盘录入时的所有情况。
        比如:录入年龄时超出范围，录入年龄时录入了abc等情况
         */
        GirlFriend g = new GirlFriend();
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("请输入姓名：");
                String name = sc.nextLine();
                g.setName(name);
                System.out.println("请输入年龄：");
                String ageStr = sc.nextLine();
                int age = Integer.parseInt(ageStr);
                g.setAge(age);
                break;
            } catch (NumberFormatException e) {
                System.out.println("年龄的格式有误");
            }catch (NameFormatException e) {
                System.out.println("姓名长度有误");
            }catch (AgeOutOfBound e) {
                System.out.println("年龄大小有误");
            }
        }
        System.out.println(g);


    }
}
