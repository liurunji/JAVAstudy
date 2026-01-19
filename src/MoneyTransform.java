import java.util.Scanner;

public class MoneyTransform {
    public static void main(String[] args) {
        //佰拾万仟佰拾元
        Scanner sc = new Scanner(System.in);
        int money;

        //1.判定有效性
        while (true) {
            System.out.println("请输入金额");
            money = sc.nextInt();    //4982
            if (money >= 0 && money <= 9999999) {
                break;
            } else {
                System.out.println("输入有误，请重新输入");
            }
        }

        //2.得到输入数字的大写
        String result = "";
        int count = 0;
        while (money > 0) {
            int ge = money % 10;    // 2 8 9 4
            result = getUpper(ge) + result;   //肆玖捌贰
            money = money / 10;
            count++;  //为了得到输入金额的位数
        }
        System.out.println(result);   //肆玖捌贰

        //3.一共七位，要补齐缺省的零  eg：零零零肆玖捌贰
        int buwei = 7 - count;   //一共七位，减输入位数得要补得位数
        for (int i = 0; i < buwei; i++) {
            result = "零" + result;
        }
        System.out.println(result);   //零零零肆玖捌贰

        //4.加上每一位对应的单位
        String finalResult = "";
        String[] unit = {"佰", "拾", "万", "仟", "佰", "拾", "元"};
        //                零    零    零    肆    玖    捌     贰
        for (int i = 0; i < result.length(); i++) {
            finalResult = finalResult + result.charAt(i) + unit[i];
        }
        System.out.println(finalResult);  //零佰零拾零万贰仟捌佰玖拾肆元

    }

    public static String getUpper(int index) {
        //String[] str = {"佰", "拾", "万", "仟", "佰", "拾", "元"};
        String[] str = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        return str[index];
    }

}
