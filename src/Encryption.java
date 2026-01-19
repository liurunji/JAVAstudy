import java.util.Scanner;

public class Encryption {
    public static void main(String[] args) {
        /*
        某系统的数字密码(大于0)。比如1983，采用加密方式进行传输规则如下:
        每位数加上5再对10求余，
        最后将所有数字反转，
        得到一串新数。
         */

        int weishu = 0; //记录密码的位数

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入密码：");
        int password = sc.nextInt();
        int copyPassword = password;
        while (copyPassword > 0) {   //得到密码的位数
            copyPassword = copyPassword / 10;
            weishu++;
        }
        System.out.println(weishu);
        int[] arr = new int[weishu];
        int i = arr.length - 1;
        //将密码按位存到数组中
        while (password > 0) {
            arr[i] = password % 10;
            password = password / 10;
            i--;
        }

        //加密操作每位数加上5再对10求余，
        for (int j = 0; j < arr.length; j++) {
            arr[j] = (arr[j] + 5) % 10;
        }

        //翻转操作
        for (int j = 0, k = arr.length - 1; j < k; j++, k--) {
            int temp = arr[j];
            arr[j] = arr[k];
            arr[k] = temp;
        }

        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }

        //以数字形式展示
        int result = 0;
        for (int j = 0; j < arr.length; j++) {
            result = result * 10 + arr[j];
        }
        System.out.println("\n" + result);

    }
}
