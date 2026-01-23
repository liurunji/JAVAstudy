package io.randomCall;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Demo5 {
    public static void main(String[] args) throws IOException {
        /*
        需求:
        一个文件里面存储了班级同学的姓名，每一个姓名占一行。
        要求通过程序实现随机点名器。
        运行效果:
        被点到的学生不会再被点到
        如果班级中所有的学生都点完了，需要自动的重新开启第二轮点名
        细节1:假设班级有10个学生，每一轮中每一位学生只能被点到一次，程序运行10次，第一轮结束
        细节2:第11次运行的时候，我们自己不需要手动操作本地文件，要求程序自动开始第二轮点名
         */

        BufferedReader br1 = new BufferedReader(new FileReader("src/io/randomCall/names.txt"));
        ArrayList<String> nameList = new ArrayList<>();
        String line;
        while ((line = br1.readLine()) != null) {
            nameList.add(line);
        }
        br1.close();

/*
没达到题目要求 这里是一次性模拟，题目要求运行这么多次
 */
        for (int i = 0; i < 5; i++) {
            System.out.println("----------第"+(i+1)+"轮点名----------");
            ArrayList<String> nameTempList = new ArrayList<>();
            nameTempList.addAll(nameList);  //数据复制到一个新集合中
            while (true){
                if (nameTempList.size() == 0){
                    break;
                }
                Collections.shuffle(nameTempList);
                String name = nameTempList.get(0);
                System.out.println(name);
                nameTempList.remove(0);
            }
        }



    }
}
