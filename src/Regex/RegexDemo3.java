package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo3 {
    public static void main(String[] args) {
        //需求:把下面文本中的座机电话，邮箱，手机号，热线都爬取出来。
        // 来黑马程序员学习Java，
        //手机号:18512516758，18512508907
        //或者联系邮箱:boniu@itcast.cn，座机电话:01036517895，010-98951256邮箱:bozai@itcast.cn，
        //热线电话:400-618-9090，400-618-4000，4006184000，4006189090

        String str = "来黑马程序员学习Java，\n" +
                "手机号:18512516758，18512508907\n" +
                "或者联系邮箱:boniu@itcast.cn，座机电话:01036517895，010-98951256邮箱:bozai@itcast.cn，\n" +
                "热线电话:400-618-9090，400-618-4000，4006184000，4006189090";

        //手机号正则表达式：1[3-9]\\d{9}
        //邮箱：(([^<>()\\.,;:\s@"]+(\.[^<>()\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))
        //邮箱：\\w+@(\w&&(^_)){2,6}(\\.[a-zA-Z]{2,3}){1,2}
        String regex = "(1[3-9]\\d{9})" +
                "|(\\w+@[\\w&&[^_]]{2,6}(\\.[a-zA-Z]{2,3}){1,2})" +
                "|((?:(?:\\d{3}-)?\\d{8}|^(?:\\d{4}-)?\\d{7,8})(?:-\\d+)?)" +
                "|(400-?[1-9]\\d{2}-?\\d{4})";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        while (m.find()){
            String s = m.group();
            System.out.println(s);
        }
    }
}
