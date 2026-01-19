package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;

public class Demo2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张三-23", "李四-24", "王五-25", "小张-18");
        //完整的匿名内部类
        /*
        list.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                String[] str = s.split("-");
                String s1 = str[1];
                int i = Integer.parseInt(s1);
                return  i ;

            }
        }).forEach(s-> System.out.println(s));
         */
        list.stream().map((String s) -> Integer.parseInt(s.split("-")[1])).forEach(s -> System.out.println(s));

    }
}
