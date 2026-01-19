package collection.set.practice;

import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        /*
        需求创建一个存储学生对象的集合，存储多个学生对象。
        使用程序实现在控制台遍历该集合，
        要求:学生对象的成员变量值相同，我们就认为是同一个对象
         */
        Student s1 = new Student("张三", 23);
        Student s2 = new Student("李四", 24);
        Student s3 = new Student("王五", 25);
        Student s4 = new Student("张三", 23);
        Student s5 = new Student("小明", 23);
        Student s6 = new Student("小黄", 25);
        Student s7 = new Student("小于", 26);

        HashSet<Student> h = new HashSet<>();
        System.out.println(h.add(s1));
        System.out.println(h.add(s2));
        System.out.println(h.add(s3));
        System.out.println(h.add(s4));
        h.add(s5);
        h.add(s6);
        h.add(s7);

        System.out.println(h);

        for (Student s : h) {
            System.out.println(s);
        }

    }
}
