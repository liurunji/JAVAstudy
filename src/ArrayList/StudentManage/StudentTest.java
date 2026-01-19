package ArrayList.StudentManage;

import java.util.ArrayList;

public class StudentTest {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        Student stu1 = new Student("张三", 25);
        Student stu2 = new Student("李四", 20);

        list.add(stu1);
        list.add(stu2);
        for (int i = 0; i < list.size(); i++) {

            System.out.println("姓名为：" + list.get(i).getName() + "，年龄为：" + list.get(i).getAge());
        }
    }


}
