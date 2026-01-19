package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo2 {
    public static void main(String[] args) {
        String str = "Java自从95年问世以来，经历了很多版本，目前企业中用的最多的是Java8和Java11，" +
                "因为这两个是长期支持版本，下一个长期支持版本是Java17，相信在未来不久Java17也会逐渐登上历史舞台";

        //获取正则表达式的对象
        Pattern p = Pattern.compile("Java\\d{0,2}");
        //m要在str中寻找符合p规则的小串
        Matcher m = p.matcher(str);
        //m.find()方法：找不到返回false，找到了返回true，并且在底层记录找到的小串的起始索引，结束索引+1
        //[起始索引，结束索引+1)
        while (m.find()){   //能找到会继续找，找不到就结束
            //m.group方法返回找到的小串
            String s = m.group();
            System.out.println(s);
        }


    }
}
