package collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;

public class demo1 {
    public static void main(String[] args) {
        /*
        利用Set系列的集合，添加字符串，并使用多种方式遍历。
        迭代器
        增强for
        Lambda表达式
         */

        Set<String> s = new HashSet<>();
        boolean b1 = s.add("张三");
        boolean b2 = s.add("张三");
        boolean b3 = s.add("李四");
        boolean b4 = s.add("王五");
        s.add("小明");

        //set集合的特点：无序、不重复、无索引
        System.out.println(b1 + " " + b2 + " " + b3 + " " + b4);

        //1.迭代器遍历
        Iterator<String> it = s.iterator();
        while (it.hasNext()) {
            String str = it.next();
            System.out.println(str);
        }
        System.out.println("-----------------------------------");

        //2.增强for
        for (String str : s) {
            System.out.println(str);
        }
        System.out.println("-----------------------------------");

        //3.lambda表达式for each循环
        s.forEach(str -> System.out.println(str));

    }
}
