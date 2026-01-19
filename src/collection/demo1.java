package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

public class demo1 {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("aaa");
        coll.add("bbb");
        coll.add("ccc");
        coll.add("ddd");

        //迭代器遍历
        Iterator<String> it = coll.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }


        //增强for循环遍历
        for (String s : coll) {
            System.out.println(s);
        }

        //lambda表达式（for each循环遍历）
        /*
        匿名内部类方式
         coll.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
         */
        //最简lambda表达式
        coll.forEach(s -> System.out.println(s));


    }
}
