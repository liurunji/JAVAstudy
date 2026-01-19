package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

public class demo2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");

        //1.迭代器遍历：遍历时想删元素
        Iterator<String> it1 = list.iterator();
        while (it1.hasNext()) {
            String s = it1.next();
            if ("bbb".equals(s)){
                it1.remove();
            }
            System.out.println(s);
        }
        System.out.println("--------------------------");

        //2.列表迭代器遍历：遍历时想添加元素
        ListIterator<String> it = list.listIterator();
        while (it.hasNext()) {
            String s = it.next();
            if ("ccc".equals(s)){
                it.add("qqq");
            }
            System.out.println(s);
        }
        System.out.println("--------------------------");

        //3.增强for循环遍历:仅想遍历
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("--------------------------");

        //4.普通for循环：想操作索引时可用
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            System.out.println(s);
        }
        System.out.println("--------------------------");

        //5.lambda表达式(for each循环)：只想遍历
        list.forEach(s -> System.out.println(s));


    }
}
