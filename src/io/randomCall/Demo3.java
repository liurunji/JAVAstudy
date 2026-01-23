package io.randomCall;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Demo3 {
    public static void main(String[] args) throws IOException {
         /*
        需求:
        一个文件里面存储了班级同学的信息，每一个学生信息占一行。
        格式为:张三-男-23
        要求通过程序实现随机点名器
        运行效果:
        70%的概率随机到男生
        30%的概率随机到女生
        总共随机100万次，统计结果。
        注意观察:看生成男生和女生的比例是不是接近于7:3
         */

        //7:3的概率可以通过抓取10个0和1，其中7个1,3个0来表示，然后放到到一个集合当中，然后从集合当中抽取
        ArrayList<String> boyNameList = new ArrayList<>();
        ArrayList<String> girlNameList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("src/io/randomCall/allnames.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String gender = line.split("-")[1];
            if (gender.equals("男")) {
                boyNameList.add(line);
            } else {
                girlNameList.add(line);
            }
        }
        br.close();

        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0);
        int boyCount = 0, girlCount = 0;
        Random r = new Random();

        for (int j = 0; j < 100; j++) {
            int index = r.nextInt(list.size());
            Integer i = list.get(index);
            if (i == 1) { //抽中男生
                Collections.shuffle(boyNameList);
                String boyName = boyNameList.get(0);
                System.out.println(boyName);
                boyCount++;
            } else {
                //抽中女生
                Collections.shuffle(girlNameList);
                String girlName = girlNameList.get(0);
                System.out.println(girlName);
                girlCount++;
            }
        }
        System.out.println("男：" + boyCount + ",女：" + girlCount);

    }

}
