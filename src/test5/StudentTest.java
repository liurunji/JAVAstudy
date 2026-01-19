package test5;

import java.util.Scanner;

public class StudentTest {
    //定义一个长度为3的数组，数组存储1~3名学生对象作为初始数据，学生对象的学号，姓名各不相同。
    // 学生的属性:学号，姓名，年龄
    //要求1:再次添加一个学生对象，并在添加的时候进行学号的唯一性判断。
    //要求2:添加完毕之后，遍历所有学生信息，
    //要求3:通过id删除学生信息
    //如果存在，则删除，如果不存在，则提示删除失败。
    // 要求4:删除完毕之后，遍历所有学生信息。
    // 要求5:查询数组id为“heima002”的学生，如果存在，则将他的年龄+1岁
    public static void main(String[] args) {
        Student[] arr = new Student[3];
        Student s1 = new Student(1, "张三", 21);
        Student s2 = new Student(2, "李四", 23);
        Student s3 = new Student(3, "小明", 18);

        //把学生对象添加到数组中
        arr[0] = s1;
        arr[1] = s2;
        arr[2] = s3;

        //再次添加一个新对象
        Student s4 = new Student(4, "小张", 28);

        //唯一性判断
        boolean flag = contain(arr, s4.getId());
        if (flag) {
            //已经存在了
            System.out.println("ID已经存在，请重新输入");
        } else {
            //不存在添加信息
            //1.原数组未满
            //2.原数组已满
            int count = getCount(arr);
            if(count< arr.length){
                //1.原数组未满,直接加入原先的数组
                //这里的count既是已有元素的个数也是新加入对象的要存储的索引位置
                arr[count] = s4;
                //遍历所有学生信息
                printArr(arr);
            }else{
                //2.原数组已满，创建新的数组 = 原数组长度+1，然后把原有数据拷贝到新的数组里
                Student[] newArr = creatNewArr(arr);
                newArr[count] = s4;
                //遍历所有学生信息
                printArr(newArr);
            }

        }
        //要求3:通过id删除学生信息
        //如果存在，则删除，如果不存在，则提示删除失败。





    }

    private static void printArr(Student[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null)
            System.out.println("学号："+ arr[i].getId()+"，姓名:"+ arr[i].getName()
                    +"，年龄:"+ arr[i].getAge());
        }
    }

    //判断是否有重复的ID
    public static boolean contain(Student[] arr, int id) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                if (arr[i].getId() == id)
                    return true;
            }
        }
        return false;
    }

    //得到现在数组已经存了几个对象，用于判断数组是否满了
    public static int getCount(Student[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null)
                count++;
        }
        return count;
    }

    //创建新的数组，新的数组是原来的数组长度+1，并且拥有原先的数据
    public static Student[] creatNewArr(Student[] arr){
        Student[] newArr = new Student[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    //根据ID删除学生信息
    public static int getIndex(Student[] arr,int id){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=null){
                if(arr[i].getId() == id){
                    return i;
                }
            }
        }
        return -1;
    }

}
