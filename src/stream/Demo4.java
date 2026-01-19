package stream;

import java.util.*;
import java.util.stream.Collectors;

public class Demo4 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "林墨-男-28", "苏映雪-女-24", "陈远-男-35", "沈清秋-女-31",
                "周明宇-男-42", "顾晚晴-女-27", "陆知行-男-33","苏映雪-女-24","苏映雪-女-24", "叶蓁蓁-女-29", "秦安-男-46", "许悠然-女-38");

        List<String> newList = list.stream().filter(s -> "男".equals(s.split("-")[1])).collect(Collectors.toList());
        System.out.println(newList);

        Set<String> newSet = list.stream().filter(s -> "女".equals(s.split("-")[1])).collect(Collectors.toSet());
        System.out.println(newSet);

    }
}
