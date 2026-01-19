package collection.map.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class demo2 {
    public static void main(String[] args) {
        Map<String, String> m = new HashMap<>();
        m.put("河流之王", "塔姆");
        m.put("沙漠皇帝", "阿兹尔");
        m.put("星界游神", "巴德");

        //通过键值对的方法进行遍历
        //把所有的键值对放到单列集合中
        //通过entrySet方法获取所有键值对象，并返回set集合
        Set<Map.Entry<String, String>> entries = m.entrySet();
        //增强for遍历单列集合entries
        for (Map.Entry<String, String> entry : entries) {
            //使用getKey和getValue获取键和值
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "->" + value);
        }

        System.out.println("----------------------------------");

        //迭代器遍历单列集合entries
        Iterator<Map.Entry<String, String>> it = entries.iterator();
        while (it.hasNext()) {
            //it.next指向当前键值对
            Map.Entry<String, String> entry = it.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "->" + value);
        }

        System.out.println("----------------------------------");

        //lambda表达式遍历单列集合entries
        entries.forEach(entry -> {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "->" + value);
        });
    }
}
