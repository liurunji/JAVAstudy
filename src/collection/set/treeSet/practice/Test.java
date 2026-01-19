package collection.set.treeSet.practice;

import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        /*
        需求:创建5个学生对象属性:(姓名,年龄，语文成绩,数学成绩,英语成绩)
        按照总分从高到低输出到控制台
        如果总分一样，按照语文成绩排
        如果语文一样，按照数学成绩排
        如果数学成绩一样，按照英语成绩排
        如果英文成绩一样，按照年龄排
        如果年龄一样，按照姓名的字母顺序排
        如果都一样，认为是同一个学生，不存。
         */
        Student s1 = new Student("zhangsan", 23, 80, 87, 90);
        Student s2 = new Student("lisi", 24, 87, 88, 92);
        Student s3 = new Student("wangwu", 25, 90, 92, 95);
        Student s4 = new Student("xiaoming", 26, 83, 77, 90);
        Student s5 = new Student("xiaowang", 26, 100, 99, 98);
        Student s6 = new Student("xiaoyong", 23, 86, 89, 93);

        TreeSet<Student> ts = new TreeSet<>();

        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);
        ts.add(s6);

        for (Student t : ts) {
            System.out.println(t);
        }

    }
}
