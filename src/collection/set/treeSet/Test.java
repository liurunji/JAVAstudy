package collection.set.treeSet;

import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        //TreeSet的特点无重复、无索引、可排序
        Student s1 = new Student("zhangsan", 23);
        Student s2 = new Student("lisi", 24);
        Student s3 = new Student("wangwu", 25);

        TreeSet<Student> ts = new TreeSet<>();

        ts.add(s1);
        ts.add(s2);
        ts.add(s3);

        for (Student t : ts) {
            System.out.println(t);
        }

    }
}
