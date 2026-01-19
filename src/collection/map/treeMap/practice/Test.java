package collection.map.treeMap.practice;

import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        /*
        需求2:
        键:学生对象
        值:籍贯
        要求:按照学生年龄的升序排列，年龄一样按姓名的字母排列。同姓名年龄视为同一个人。
         */
        Student s1 = new Student("zhangsan", 23);
        Student s2 = new Student("lisi", 24);
        Student s3 = new Student("wangwu", 25);
        Student s4 = new Student("awei", 25);

        TreeMap<Student, String> tm = new TreeMap<>();

        tm.put(s1, "山东");
        tm.put(s2, "江苏");
        tm.put(s3, "安徽");
        tm.put(s4, "上海");

        System.out.println(tm);
    }
}
