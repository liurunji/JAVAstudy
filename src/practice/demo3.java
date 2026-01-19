package practice;

public class demo3 {
    public static void main(String[] args) {
        //定义一个方法自己实现toBinaryString方法的效果，将一个十进制整数转成字符串表示的二进制
        String s1 = method1(10);
        System.out.println(s1);
        String s2 = method2(10);
        System.out.println(s1);
        String s3 = Integer.toBinaryString(10);
        System.out.println(s3);
    }

    public static String method1(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int yushu = num % 2;
            num = num / 2;
            sb.append(yushu);
        }
        //调用stringbuilder的reverse方法进行倒转
        String result = sb.reverse().toString();

        return result;
    }


    public static String method2(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int yushu = num % 2;
            num = num / 2;
            //把余数插入到0索引的位置
            sb.insert(0,yushu);
        }
        String result = sb.toString();

        return result;
    }
}
