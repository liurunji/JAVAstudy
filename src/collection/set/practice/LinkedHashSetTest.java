package collection.set.practice;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {
    public static void main(String[] args) {
        Student s1 = new Student("张三", 23);
        Student s2 = new Student("李四", 24);
        Student s3 = new Student("王五", 25);
        Student s4 = new Student("张三", 23);
        Student s5 = new Student("小明", 23);
        Student s6 = new Student("小黄", 25);
        Student s7 = new Student("小于", 26);

        //LinkedHashSet的特点：有序、不重复、无索引，底层使用双向链表记录顺序
        LinkedHashSet<Student> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(s1);
        linkedHashSet.add(s2);
        linkedHashSet.add(s3);
        linkedHashSet.add(s4);
        linkedHashSet.add(s5);
        linkedHashSet.add(s6);
        linkedHashSet.add(s7);

        System.out.println(linkedHashSet);


    }



}
