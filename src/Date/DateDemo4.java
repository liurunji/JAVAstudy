package Date;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateDemo4 {
    public static void main(String[] args) {
        //获取时间对象
        ZonedDateTime now = Instant.now().atZone(ZoneId.of("Asia/Shanghai"));
        //解析/格式化器
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss EE a");
        //格式化
        String s = dtf.format(now);

        System.out.println(s);

    }
}
