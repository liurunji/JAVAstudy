import java.util.Scanner;

public class ToRomanFigure {
    public static void main(String[] args) {
        //键盘录入一个字符串要求1:长度为小于等于9
        //要求2:只能是数字
        //将内容变成罗马数字
        //下面是阿拉伯数字跟罗马数字的对比关系:
        //Ⅰ-1，Ⅱ-2，Ⅲ-3，Ⅳ-4，Ⅴ-5，Ⅵ-6.Ⅶ-7.Ⅷ-8.Ⅸ-9
        //注意点:
        //罗马数字里面是没有0的如果键盘录入的数字包含0，可以变成””(长度为0的字符串)
        Scanner sc = new Scanner(System.in);
        boolean flag = true;    //标识符，用于判定是否为数字
        String str = "";
        while (true) {
            System.out.println("请输入数字字符串：");
            str = sc.next();                               //2586
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                    flag = false;
                    break;
                }
            }
            if (flag && str.length() <= 9) {
                break;
            } else {
                System.out.println("输入有误，请重新输入");
            }
        }
        //System.out.println(str);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - '0';    //2  5  8  6
            sb.append(getRoman(index));
        }
        String result = sb.toString();
        System.out.println(result);
    }

    //根据索引取得对应罗马数字
    public static String getRoman(int index) {
        String[] str = {"", "Ⅰ", "Ⅱ", "Ⅲ", "Ⅳ", "Ⅴ", "Ⅵ", "Ⅶ", "Ⅷ", "Ⅸ"};
        return str[index];
    }

}
