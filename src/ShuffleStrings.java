import java.util.Random;
import java.util.Scanner;

public class ShuffleStrings {

    public static void main(String[] args) {
        //打乱字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串");
        String str = sc.next();
        char[] arr = str.toCharArray();
        Random r = new Random();

        for (int i = 0; i < arr.length; i++) {
            int randomIndex = r.nextInt(arr.length);
            char temp = arr[randomIndex];
            arr[randomIndex] = arr[i];
            arr[i] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        String result = sb.toString();
        System.out.println(result);


    }


}
