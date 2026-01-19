package stream.demo8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo8 {
    public static void main(String[] args) {
        /*
        现在有两个ArrayList集合
        第一个集合中:存储6名男演员的名字和年龄。第二个集合中:存储6名女演员的名字和年龄姓名和年龄中间用逗号隔开。比如:张三，23
        要求完成如下的操作:
        1，男演员只要名字为3个字的前两人
        2，女演员只要姓杨的，并且不要第一个
        3，把过滤后的男演员姓名和女演员姓名合并到一起
        4，将上一步的演员信息封装成Actor对象。
        5.将所有的演员对象都保存到List集合中。
         */
        ArrayList<String> manList = new ArrayList<>();
        ArrayList<String> womanList = new ArrayList<>();
        Collections.addAll(manList, "陆明轩,31", "陈峰,28", "周子墨,35", "刘洋,42", "赵致远,27", "王磊,39");
        Collections.addAll(womanList, "杨清婉,29", "林薇,25", "沈知意,33", "杨婷,37", "顾安然,26", "杨琳,34");
        Stream<String> stream1 = manList.stream().filter(s -> s.split(",")[0].length() == 3).limit(2);
        Stream<String> stream2 = womanList.stream().filter(s -> s.startsWith("杨")).skip(1);
        /*
        List<Actor> list = Stream.concat(stream1, stream2).map(new Function<String, Actor>() {
            @Override
            public Actor apply(String s) {//s:周子墨,35
                String name = s.split(",")[0];
                int age = Integer.parseInt(s.split(",")[1]);
                Actor a = new Actor(name, age);
                return a;
            }
        }).collect(Collectors.toList());
         */

        //lambda表达式
        List<Actor> list = Stream.concat(stream1, stream2)
                .map(s -> new Actor(s.split(",")[0], Integer.parseInt(s.split(",")[1])))
                .collect(Collectors.toList());

        System.out.println(list);


    }
}
