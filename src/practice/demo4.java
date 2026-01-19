package practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class demo4 {
    public static void main(String[] args) throws ParseException {
        //请使用代码实现计算你活了多少天，用JDK7和JDK8两种方式完成
        String born = "2001-06-26";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date bornDate = sdf.parse(born);
        long bornDateTime = bornDate.getTime();
        long now = System.currentTimeMillis();
        int days1 = (int) ((now - bornDateTime) / 1000 / 60 / 60 / 24);
        System.out.println(days1);


        LocalDate ld1 = LocalDate.of(2001, 06, 26);
        LocalDate ld2 = LocalDate.now();
        long days2 = ChronoUnit.DAYS.between(ld1, ld2);
        System.out.println(days2);
    }

    
}
