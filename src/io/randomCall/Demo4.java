package io.randomCall;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Demo4 {
    public static void main(String[] args) throws IOException {
        /*
        需求:
        一个文件里面存储了班级同学的姓名，每一个姓名占一行。要求通过程序实现随机点名器。第三次必定是张三同学
        运行效果:
        第一次运行程序:随机同学姓名1
        第二次运行程序:随机同学姓名2
        第三次运行程序:张三
         */

        //所有名字读到集合中
        BufferedReader br1 = new BufferedReader(new FileReader("src/io/randomCall/allnames.txt"));
        ArrayList<String> nameList = new ArrayList<>();
        String line;
        while ((line = br1.readLine()) != null) {
            nameList.add(line);
        }
        br1.close();

        //count.txt专门保存运行次数
        BufferedReader br2 = new BufferedReader(new FileReader("src/io/randomCall/count.txt"));
        String countStr = br2.readLine();
        int count = Integer.parseInt(countStr);
        count++;
        System.out.println(count);
        br2.close();

        if (count!=3){
            //不是第三次则输出随机姓名
            Collections.shuffle(nameList);
            String name = nameList.get(0).split("-")[0];
            System.out.println(name);
        }else {
            //第三次则直接诶输出张三
            System.out.println("张三");
        }

        //将更新后的次数写回文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/io/randomCall/count.txt"));
        bw.write(count+"");
        bw.close();
    }
}
