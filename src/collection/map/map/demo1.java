package collection.map.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class demo1 {
    public static void main(String[] args) {
        Map<String, String> m = new HashMap<>();
        m.put("张三", "李四");
        m.put("小张", "小王");
        m.put("小黄", "小勇");

        //通过键找值
        //1.获取所有键并放入一个单列集合中
        Set<String> s = m.keySet();
        //2.遍历单列集合，得到每一个键
        //2.1这里遍历单列集合的方法是增强for循环
        for (String key : s) {
            //对每一个键，调用Map的get方法得到键对应的值
            String value = m.get(key);
            System.out.println(key + "->" + value);
        }

        System.out.println("-------------------------------");

        //练习：2.2 迭代器遍历单列集合
        Iterator<String> it = s.iterator();
        while (it.hasNext()) {
            String key = it.next();
            String value = m.get(key);
            System.out.println(key + "->" + value);
        }

        System.out.println("-------------------------------");

        //练习：2.3 lambda表达式单列集合
        s.forEach(key -> {
            String value = m.get(key);
            System.out.println(key + "->" + value);
        });


    }
}
