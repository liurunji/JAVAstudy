package io.login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        /*
        将正确的用户名和密码手动保存在本地的userinfo.txt文件中
        保存格式为:username=zhangsan&password=123
        让用户键盘录入用户名和密码
        比较用户录入的和正确的用户名密码是否一致
        如果一致则打印登陆成功
        如果不一致则打印登陆失败
         */
        BufferedReader br = new BufferedReader(new FileReader("src/io/login/userInfo.txt"));
        String line = br.readLine();
        String username = line.split("&")[0].split("=")[1];
        String password = line.split("&")[1].split("=")[1];
        System.out.println(username + "  " + password);
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String usernameInput = sc.nextLine();
        System.out.println("请输入密码");
        String passwordeInput = sc.nextLine();
        if (username.equals(usernameInput) && password.equals(passwordeInput)) {
            System.out.println("登录成功");
        } else {
            System.out.println("登陆失败");
        }
    }
}
