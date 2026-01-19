package references.demo1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        //集合里面存储姓名和年龄，要求封装成student对象并收集到List集合中
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"zhansgan,23","lisi,24","wangwu,25");
        List<Student> newList = list.stream().map(Student::new).collect(Collectors.toList());
        System.out.println(newList);
    }
}
