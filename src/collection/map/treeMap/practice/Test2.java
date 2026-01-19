package collection.map.treeMap.practice;

import java.util.TreeMap;

public class Test2 {
    public static void main(String[] args) {
         /*
        需求2:
        键:学生对象
        值:籍贯
        要求:按照学生年龄的升序排列，年龄一样按姓名的字母排列。同姓名年龄视为同一个人。
         */
        Student2 s1 = new Student2("zhangsan", 23);
        Student2 s2 = new Student2("lisi", 24);
        Student2 s3 = new Student2("wangwu", 25);
        Student2 s4 = new Student2("awei", 25);

        TreeMap<Student2, String> tm = new TreeMap<>((o1, o2) -> {
            int i = o1.getAge() - o2.getAge();
            i = i == 0 ? o1.getName().compareTo(o2.getName()) : i;
            return i;
        });

        tm.put(s1, "山东");
        tm.put(s2, "江苏");
        tm.put(s3, "安徽");
        tm.put(s4, "上海");

        System.out.println(tm);
    }
}
