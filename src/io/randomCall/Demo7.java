package io.randomCall;

import algorithm.search.BinarySearch;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/*
TXT文件中事先准备好一些学生信息，每个学生的信息独占一行，
要求1:每次被点到的学生，再次被点到的概率在原先的基础上降低一半，
举例:80个学生，点名5次，每次都点到小A，概率变化情况如下:
第一次每人概率:1.25%。
第二次小A概率:0.625%。   其他学生概率:1.2579%
第三次小A概率:0.3125%。  其他学生概率:1.261867%
第四次小A概率:0.15625%。 其他学生概率:1.2638449%
第五次小A概率:0.078125%  其他学生概率:1.26483386%
 */
public class Demo7 {
    public static void main(String[] args) throws IOException {
        //把文件中的数据读到内存当中
        ArrayList<Student> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("src/io/randomCall/nameWithWeight.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] str = line.split("-");
            Student stu = new Student(str[0], str[1], Integer.parseInt(str[2]), Double.parseDouble(str[3]));
            list.add(stu);
        }
        br.close();
        System.out.println(list);
        //统计总的权重
        double weight = 0.0;
        for (Student s : list) {
            weight = weight + s.getWeight();
        }
        System.out.println(weight);

        //计算每个人的权重比例
        //用数组来存储每个人的权重
        double[] arr = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            //用每个人的权重/总权重  得到个人的权重比例
            arr[i] = list.get(i).getWeight() / list.size();
        }
        System.out.println(Arrays.toString(arr));
        //[0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1]
        //可以用范围来表示抽中的概率
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i] + arr[i - 1];
        }
        System.out.println(Arrays.toString(arr));
        //[0.1, 0.2, 0.30000000000000004, 0.4, 0.5, 0.6, 0.7, 0.7999999999999999, 0.8999999999999999, 0.9999999999999999]
        //[0,0.1] 第1个人 [0.1,0.2] 第2个人   [0.2,0.3] 第3个人   [0.3,0.4] 第4个人
        //我从[0,1]随机抽一个数，比如0.308，那么就代表我抽中的是第四个人
        double r = Math.random();  //从[0,1)抽一个随机小数
        System.out.println(r);
        //使用二分查找查找这个随机数在数组中的位置，
        // 二分查找找不到该元素则会返回该元素应该插入的位置的相反数-1  即:  返回的结果=-插入位置-1
        int index = -(Arrays.binarySearch(arr, r) + 1);  //此坐标就可表示被插入的位置也就能表示被抽出的人
        System.out.println(index);
        System.out.println("被抽中的人是:" + list.get(index).getName());

        //抽中以后此人的权重减半
        list.get(index).setWeight(list.get(index).getWeight() / 2);
        System.out.println(list.get(index));
        //修改后的结果要写入文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/io/randomCall/nameWithWeight.txt"));
        for (Student stu : list) {
            bw.write(stu.toString());
            bw.newLine();
        }
        bw.close();

    }
}
