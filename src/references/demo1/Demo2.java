package references.demo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Function;

public class Demo2 {
    public static void main(String[] args) {
        /*
        需求:
        创建集合添加学生对象
        学生对象属性:name，age
        要求:
        把姓名和年龄拼接成:张三-23的字符串，并放到数组当中使用方法引用完成
         */
        Student s1 = new Student("zhansgan",23);
        Student s2 = new Student("lisi",24);
        Student s3 = new Student("wangwu",25);
        Student s4 = new Student("zhaoliu",26);
        ArrayList<Student> list = new ArrayList<>();
        Collections.addAll(list,s1,s2,s3,s4);
        /*
        list.stream().map(new Function<Student, String>() {
            @Override
            public String apply(Student student) {
                return student.getName()+"-"+student.getAge();
            }
        }).forEach(s-> System.out.println(s));
        */

        System.out.println("----------------------");
        String[] arr = list.stream().map(Student::toString).toArray(String[]::new);
        System.out.println(Arrays.toString(arr));
    }
}
