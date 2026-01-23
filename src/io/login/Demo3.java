package io.login;

import java.io.*;
import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) throws IOException {
         /*
        需求：写一个登陆小案例（添加锁定账号功能）

        步骤：
        	将正确的用户名和密码手动保存在本地的userinfo.txt文件中。
        	保存格式为:username=zhangsan&password=123&count=0
        	让用户键盘录入用户名和密码
        	比较用户录入的和正确的用户名密码是否一致
        	如果一致则打印登陆成功
        	如果不一致则打印登陆失败，连续输错三次被锁定

        */

        //1.读取正确的用户名和密码
        BufferedReader br = new BufferedReader(new FileReader("src/io/login/userInfo.txt"));
        String line = br.readLine();
        br.close();

        String username = line.split("&")[0].split("=")[1];
        String password = line.split("&")[1].split("=")[1];
        String countStr = line.split("&")[2].split("=")[1];
        int count = Integer.parseInt(countStr);


        Scanner sc = new Scanner(System.in);

        //2.用户键盘录入用户名和密码
        System.out.println("请输入用户名");
        String usernameInput = sc.nextLine();
        System.out.println("请输入密码");
        String passwordInput = sc.nextLine();

        //3.比较
        if (username.equals(usernameInput) && password.equals(passwordInput) && count < 3) {
            System.out.println("登陆成功");
            writeInfo("username=" + username + "&password=" + password + "&count=0");
        } else {
            count++;
            if (count < 3) {
                System.out.println("登陆失败,还剩下" + (3 - count) + "次机会");
            } else {
                System.out.println("用户账户被锁定");
            }

            writeInfo("username=" + username + "&password=" + password + "&count=" + count);
        }
    }

    /*
     * 作用：
     *       写出一个字符串到本地文件中
     * 参数：
     *       要写出的字符串
     * */
    public static void writeInfo(String content) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/io/login/userInfo.txt"));
        bw.write(content);
        bw.close();
    }


}
