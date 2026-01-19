import java.util.Scanner;

public class RenverseString {
    //定义一个方法，实现字符串反转。
    // 键盘录入一个字符串，调用该方法后，在控制台输出结果例如，键盘录入 abc，输出结果 cba
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String str = sc.next();
        String result = reverseString(str);
        System.out.println(result);
    }

    public static String reverseString(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result = result + str.charAt(i);
        }
        return result;
    }

}
