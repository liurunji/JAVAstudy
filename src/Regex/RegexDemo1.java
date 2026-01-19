package Regex;

public class RegexDemo1 {
    public static void main(String[] args) {
        //请编写正则表达式验证用户名是否满足要求。
        //要求:大小写字母，数字，下划线一共4-16位
        String regex1 = "\\w{4,16}";
        System.out.println("suer01".matches(regex1));
        System.out.println("_01w".matches(regex1));
        System.out.println("1sd".matches(regex1));

        System.out.println("--------------------------------");
        // 请编写正则表达式验证身份证号码是否满足要求。
        //简单要求:18位，前17位任意数字，最后一位可以是数字可以是大写或小写的x
        String regex2 = "[0-9]{17}[0-9xX]";
        System.out.println("123456".matches(regex2));
        System.out.println("370214200106263538".matches(regex2));
        System.out.println("37021420010626353x".matches(regex2));
        System.out.println("3c0214200106263538".matches(regex2));
        System.out.println("37021420010626353X".matches(regex2));

        // 复杂要求:按照身份证号码的格式严格要求
        System.out.println("[1-9]\\d{5}(?:18|19|20)\\d{2}(?:0[1-9]|10|11|12)(?:0[1-9]|[1-2]\\d|30|31)\\d{3}[\\dXx]");


    }
}
