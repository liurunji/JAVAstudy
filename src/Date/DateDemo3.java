package Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo3 {
    public static void main(String[] args) throws ParseException {
        /*需求:
        秒杀活动:2023年11月11日0:0:0(毫秒值)
        开始时间:2023年11月11日0:10:0(毫秒值)
        小贾下单并付款的时间为:2023年11月11日0:01:00
        小皮下单并付款的时间为:2023年11月11日0:11:0
        用代码说明这两位同学有没有参加上秒杀活动?
        */

        //定义字符串
        String startStr = "2023年11月11日 0:0:0";
        String endStr = "2023年11月11日 0:10:0";
        String orderStr1 = "2023年11月11日 0:01:00";
        String orderStr2 = "2023年11月11日 0:11:0";

        //按照格式解析字符串
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

        //将字符串解析为date类型的对象
        Date startDate = sdf.parse(startStr);
        Date endDate = sdf.parse(endStr);
        Date orderDate1 = sdf.parse(orderStr1);
        Date orderDate2 = sdf.parse(orderStr2);

        //date.getTime获取毫秒值后续进行比较
        long startTime = startDate.getTime();
        long endTime = endDate.getTime();
        long orderTime1 = orderDate1.getTime();
        long orderTime2 = orderDate2.getTime();

        //比较方法
        extracted(startTime, endTime, orderTime1);
        extracted(startTime, endTime, orderTime2);


    }

    private static void extracted(long startTime, long endTime, long orderTime) {
        if (orderTime <= endTime && orderTime >= startTime){
            System.out.println("参加活动成功");
        }else {
            System.out.println("参加活动失败");
        }
    }
}
