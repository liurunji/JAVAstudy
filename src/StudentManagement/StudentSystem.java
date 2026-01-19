package StudentManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    public static void startSystem() {
        ArrayList<Student> list = new ArrayList<>();
        while (true) {
            System.out.println("-------------欢迎来到学生管理系统----------------");
            System.out.println("1：添加学生");
            System.out.println("2：删除学生");
            System.out.println("3：修改学生");
            System.out.println("4：查询学生");
            System.out.println("5：退出");
            System.out.println("请输入您的选择:");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            switch (choose) {
                case "1":
                    addStudent(list);
                    break;
                case "2":
                    deleteStudent(list);
                    break;
                case "3":
                    updateStudent(list);
                    break;
                case "4":
                    queryStudent(list);
                    break;
                case "5":
                    //System.out.println("退出");
                    System.exit(0);
                default:
                    System.out.println("输入有误");
                    break;
            }
        }
    }

    /*
    键盘录入每一个学生信息并添加，需要满足以下要求：id唯一
     */
    public static void addStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        Student stu = new Student();
        while (true) {
            System.out.println("请输入id");
            String id = sc.next();
            boolean flag = contains(list, id);
            if (flag) {
                System.out.println("id已经存在请重新输入");
            } else {
                stu.setId(id);
                break;
            }
        }
        System.out.println("请输入姓名");
        String name = sc.next();
        stu.setName(name);
        System.out.println("请输入年龄");
        int age = sc.nextInt();
        stu.setAge(age);
        System.out.println("请输入地址");
        String address = sc.next();
        stu.setAddress(address);
        list.add(stu);
        System.out.println("添加学生信息成功");


    }

    /*
   删除功能：
	键盘录入要删除的学生id，需要满足以下要求：
* id存在删除
* id不存在，需要提示不存在，并回到初始菜单
     */
    public static void deleteStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入你要删除的学生的id：");
        String id = sc.next();
        int index = getIndex(list, id);
        if (index >= 0) {
            list.remove(index);
            System.out.println("删除学生信息成功");
        } else {
            System.out.println("id不存在，删除失败");
        }
    }

    //#### 修改功能：
    //	键盘录入要修改的学生id，需要满足以下要求
    //* id存在，继续录入其他信息
    //* id不存在，需要提示不存在，并回到初始菜单
    public static void updateStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改学生的id");
        String id = sc.next();
        boolean flag = contains(list, id);
        if (flag) {
            //存在,修改对应索引的对象的属性值
            int index = getIndex(list, id);
            System.out.println("请输入姓名：");
            String name = sc.next();
            list.get(index).setName(name);
            System.out.println("请输入年龄：");
            int age = sc.nextInt();
            list.get(index).setAge(age);
            System.out.println("请输入地址：");
            String address = sc.next();
            list.get(index).setAddress(address);

            System.out.println("学生信息修改成功！");
        }else {
            System.out.println("id不存在");
        }

    }


    /*
    查询功能：
	打印所有的学生信息，需要满足以下要求
* 如果没有学生信息，提示：当前无学生信息，请添加后再查询
* 如果有学生信息，需要按照以下格式输出。（不用过于纠结对齐的问题）
id			姓名		年龄		家庭住址
heima001	张三		23		 南京
heima002	李四		24		 北京
heima003	王五		25		 广州
heima004	赵六	 	26		 深圳
     */
    public static void queryStudent(ArrayList<Student> list) {
        System.out.println("查询学生");
        if (list.size() == 0) {
            System.out.println("当前无学生信息，请添加后再查询");
            return;
        }
        System.out.println("id\t\t" + "姓名\t" + "年龄\t" + "家庭住址\t");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getId() + "\t" + list.get(i).getName() + "\t"
                    + list.get(i).getAge() + "\t" + list.get(i).getAddress() + "\t");
        }
    }

    //判断id是否存在
    public static boolean contains(ArrayList<Student> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                return true;  //存在返回true
            }
        }
        return false;
    }

    //找到要删除id的对应索引
    public static int getIndex(ArrayList<Student> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id))
                return i;
        }
        return -1;
    }


}
