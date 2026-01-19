package Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Datedemo1 {
    public static void main(String[] args) throws ParseException {
        //将字符串解析为date对象
        String str = "2025-12-12 12-12-12";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date date = sdf1.parse(str);
        System.out.println(date);


        //将date时间转换为指定格式或默认格式
        Date d = new Date(0L);
        SimpleDateFormat sdf2 = new SimpleDateFormat();
        String date1 = sdf2.format(d);
        System.out.println(date1);

    }
}
