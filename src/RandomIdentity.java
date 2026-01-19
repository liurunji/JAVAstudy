/**
 * 随机验证码
 */

import java.util.Random;

public class RandomIdentity {
    public static void main(String[] args) {
        String result = "";
        Random r = new Random();
        char[] arr = new char[52];
        //26个大小字母按顺序放入数组中
        for (int i = 0; i < arr.length; i++) {
            if (i < 26) {
                arr[i] = (char) ('a' + i);
            } else {
                arr[i]= (char)('A' + i - 26);
            }
        }
        /*for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }*/

        for (int i = 0; i < 4; i++) {
            int randomIndex = r.nextInt(arr.length);  //生成一个随机属数索引
            result = result+arr[randomIndex];
        }
        int number = r.nextInt(10);
        result = result + number;
        System.out.println(result);
    }
}
