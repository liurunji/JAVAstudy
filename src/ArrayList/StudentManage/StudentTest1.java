package ArrayList.StudentManage;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentTest1 {
    public static void main(String[] args) {
        //需求:定义一个集合，添加一些学生对象，并进行遍历学生类的属性为:姓名，年龄。
        // 要求:对象的数据来自键盘录入
        ArrayList<Student> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            Student stu = new Student();
            System.out.println("请输入姓名：");
            String name = sc.next();
            System.out.println("请输入年龄：");
            int age = sc.nextInt();
            stu.setName(name);
            stu.setAge(age);
            list.add(stu);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println("姓名为：" + list.get(i).getName() + "，年龄为：" + list.get(i).getAge());
        }


    }
}
