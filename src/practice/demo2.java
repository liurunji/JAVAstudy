package practice;

public class demo2 {
    public static void main(String[] args) {
        //自己实现parseInt方法的效果，将字符串形式的数据转成整数。
        //要求:
        //字符串中只能是数字不能有其他字符
        //最少一位，最多10位
        //0不能开头
        String str = "123456789";
        String regex = "[1-9]\\d{0,9}";
        if (!str.matches(regex)) {
            System.out.println("字符串不满足要求");
        } else {
            System.out.println("字符串满足要求");
            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                int num = str.charAt(i) - '0';
                sum = sum * 10 + num;
            }
            System.out.println(sum);
        }
    }
}
