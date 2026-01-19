package collection.map.map;

import java.util.HashMap;
import java.util.Map;

public class demo3 {
    public static void main(String[] args) {
        Map<String, String> m = new HashMap<>();
        m.put("河流之王", "塔姆");
        m.put("沙漠皇帝", "阿兹尔");
        m.put("星界游神", "巴德");

        //lambda表达式
        m.forEach((key, value) -> System.out.println(key + "->" + value));

/*
        //完整匿名内部类
        m.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String key, String value) {
                System.out.println(key + "->" + value);
            }
        });
 */

    }
}
