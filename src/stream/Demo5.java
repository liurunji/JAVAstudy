package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo5 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "林墨-男-28", "苏映雪-女-24", "陈远-男-35", "沈清秋-女-31",
                "周明宇-男-42", "顾晚晴-女-27", "陆知行-男-33", "叶蓁蓁-女-29", "秦安-男-46", "许悠然-女-38");


        /*
                            toMap(键的规则，值的规则)，两个参数

                            参数一：
                            functional泛型1：流中的每一个数据的类型
                                      泛型2：map中键的数据类型
                            方法apply：形参：流中的每一个数据的类型
                                     方法体：生成键的代码
                                     返回值：生成的键

                            参数二：
                            functional泛型1：流中的每一个数据的类型
                                      泛型2：map中值的数据类型
                            方法apply：形参：流中的每一个数据的类型
                                     方法体：生成值的代码
                                     返回值：生成的值
                             */

        Map<String, Integer> m = list.stream()
                .filter(s -> "男".equals(s.split("-")[1])).collect(Collectors
                        .toMap(new Function<String, String>() {
                                   @Override
                                   public String apply(String s) {  //现在的流里面是林墨-男-28这种数据
                                       return s.split("-")[0];
                                   }
                               }

                                , new Function<String, Integer>() {
                                    @Override
                                    public Integer apply(String s) {
                                        return Integer.parseInt(s.split("-")[2]);
                                    }
                                }
                        ));

        System.out.println(m);
        System.out.println("-----------------------------------");

        Map<String, Integer> p1 = list.stream()
                .filter(s -> "男".equals(s.split("-")[1])).collect(Collectors
                        .toMap(s -> s.split("-")[0], s -> Integer.parseInt(s.split("-")[2])));
        System.out.println(p1);

    }
}
