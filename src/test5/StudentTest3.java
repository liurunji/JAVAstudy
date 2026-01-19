package test5;

public class StudentTest3 {
    //要求3:通过id删除学生信息
    //如果存在，则删除，如果不存在，则提示删除失败。
    // 要求4:删除完毕之后，遍历所有学生信息。
    // 要求5:查询数组id为“2”的学生，如果存在，则将他的年龄+1岁
    public static void main(String[] args) {
        Student[] arr = new Student[3];
        Student s1 = new Student(1, "张三", 21);
        Student s2 = new Student(2, "李四", 23);
        Student s3 = new Student(3, "小明", 18);

        //把学生对象添加到数组中
        arr[0] = s1;
        arr[1] = s2;
        arr[2] = s3;

        int index = getIndex(arr,2);
        if (index>=0){
            arr[index].setAge(arr[index].getAge()+1);
        }else {
            System.out.println("不存在此id");
        }

        printArr(arr);

    }

    private static void printArr(Student[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null)
                System.out.println("学号：" + arr[i].getId() + "，姓名:" + arr[i].getName()
                        + "，年龄:" + arr[i].getAge());
        }
    }


    //根据Id找到其索引
    public static int getIndex(Student[] arr, int id) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                if (arr[i].getId() == id) {
                    return i;
                }
            }
        }
        return -1;
    }
}
