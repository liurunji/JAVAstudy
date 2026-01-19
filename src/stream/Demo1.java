package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Demo1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张三", "陆临川", "沈知意", "江晚", "周默然", "叶蓁蓁", "张三丰","jieshu");
        list.stream()
                .filter(s -> s.startsWith("张"))
                .forEach(s -> System.out.println(s));

        System.out.println("------------------------------------");

        list.stream()
                .filter(s -> {
                    if (s.length() == 2) {
                        return true;
                    }
                    return false;
                })
                .forEach(s -> System.out.println(s));

        System.out.println("------------------------------------");


        list.stream().skip(3).limit(2).forEach(s-> System.out.println(s));

        System.out.println("------------------------------------");


        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "张三", "陆临川", "沈知意", "江晚", "周默然","张三","江晚","江晚","张三","张三" ,"叶蓁蓁", "张三丰");
        list1.stream().distinct().forEach(s-> System.out.println(s));

        System.out.println("------------------------------------");


        Stream.concat(list.stream(),list1.stream().distinct()).forEach(s-> System.out.println(s));

    }
}
