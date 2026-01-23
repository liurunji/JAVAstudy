package io.login;

import java.io.*;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        /*
        将正确的用户名和密码手动保存在本地的userinfo.txt文件中。
        保存格式为:username=zhangsan&password=123&count=0
        让用户键盘录入用户名和密码
        比较用户录入的和正确的用户名密码是否一致
        如果一致则打印登陆成功如果不一致则打印登陆失败，连续输错三次被锁定
         */
        BufferedReader br = new BufferedReader(new FileReader("src/io/login/userInfo.txt"));
        String line = br.readLine();
        br.close();
        String username = line.split("&")[0].split("=")[1];
        String password = line.split("&")[1].split("=")[1];
        String countStr = line.split("&")[2].split("=")[1];
        int count = Integer.parseInt(countStr);


        Scanner sc = new Scanner(System.in);


        while (true) {
            if (count >= 3) {
                System.out.println("账号已被锁定");
                break;
            }
            System.out.println("请输入用户名");
            String usernameInput = sc.nextLine();
            System.out.println("请输入密码");
            String passwordInput = sc.nextLine();

            if (username.equals(usernameInput) && password.equals(passwordInput) && count < 3) {
                System.out.println("登录成功");
                //登录成功count归零
                count = 0;
                BufferedWriter bw = new BufferedWriter(new FileWriter("src/io/login/userInfo.txt"));
                bw.write("username=" + username + "&password=" + password + "&count=" + count);
                bw.close();
                break;
            } else {
                count++;
                System.out.println("登陆失败,还剩" + (3-count) + "次机会");
                BufferedWriter bw = new BufferedWriter(new FileWriter("src/io/login/userInfo.txt"));
                bw.write("username=" + username + "&password=" + password + "&count=" + count);
                bw.close();
            }
        }


    }
}
