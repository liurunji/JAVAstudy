package collection.map.hashMap.practice1;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        /*
        创建一个HashMap集合，键是学生对象(Student)，值是籍贯(String)。
        存储三个键值对元素，并遍历
        要求:同姓名，同年龄认为是同一个学生
         */

        Student s1 = new Student("zhangsan", 23);
        Student s2 = new Student("lisi", 24);
        Student s3 = new Student("wangwu", 25);
        Student s4 = new Student("lisi", 24);

        HashMap<Student, String> m = new HashMap<>();
        m.put(s1, "山东");
        m.put(s2, "江苏");
        m.put(s3, "安徽");
        m.put(s4, "浙江");

        m.forEach((student, s) -> System.out.println(student + "->" + s));
    }
}
