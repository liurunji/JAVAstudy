package Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo2 {
    public static void main(String[] args) throws ParseException {
        /*假设，你初恋的出生年月日为:2000-11-11
        请用字符串表示这个数据，并将其转换为:2000年11月11日
         */

        //先把字符串按格式解析为date类型的对象
        String str = "2000-11-11";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf1.parse(str);
        //再把date类型按照目标格式转换（格式化）成字符串
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
        String s = sdf2.format(date);
        System.out.println(s);


    }
}
