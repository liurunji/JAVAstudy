import java.util.Scanner;

public class CharCount {
    public static void main(String[] args) {
        //键盘录入一个字符串，统计该字符串中大写字母字符，小写字母字符，数字字符出现的次数
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String str = sc.next();
        int lower = 0, upper = 0, figure = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                upper++;
            } else if (c >= 'a' && c <= 'z') {
                lower++;
            } else if ( c >= '0' &&  c <= '9') {
                figure++;
            }
        }
        System.out.println("大写字母有" + upper + "个，小写字母有" + lower + "个，数字有" + figure + "个");
    }
}
