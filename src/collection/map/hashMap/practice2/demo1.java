package collection.map.hashMap.practice2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class demo1 {
    public static void main(String[] args) {
        /*
        某个班级80名学生，现在需要组成秋游活动，班长提供了四个景点依次是(A、B、C、D),每个学生只
        能选择一个景点，请统计出最终哪个景点想去的人数最多。
         */

        //定义数组存储景点
        String[] arr = {"A", "B", "C", "D"};

        //随机数模拟80个投票，存储到list中
        ArrayList<String> list = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 80; i++) {
            int index = r.nextInt(arr.length);
            list.add(arr[index]);
        }

        //利用HashMap进行统计
        HashMap<String, Integer> m = new HashMap<>();

        for (String name : list) {
            //判断当前的景点在map中是否存在
            if (m.containsKey(name)) {
                //存在
                Integer count = m.get(name);  //取出景点对应的键值：票数
                count++;  //票数自增
                m.put(name, count);  //把景点和自增后的票数加到map中（本质是覆盖）
            } else {
                //不存在
                m.put(name, 1); //不存在直接把景点加入到map中，然后票数设为1
            }
        }

        System.out.println(m);

    }
}
