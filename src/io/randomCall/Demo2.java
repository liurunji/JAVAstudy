package io.randomCall;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Demo2 {
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

        //7:3的概率可以通过抓取10个人其中男女73开到一个集合当中，然后从集合当中抽取
        ArrayList<String> boyNameList = new ArrayList<>();
        ArrayList<String> girlNameList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("src/io/randomCall/allnames.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String gender = line.split("-")[1];
            if (gender.equals("男")){
                boyNameList.add(line);
            }else {
                girlNameList.add(line);
            }
        }
        br.close();
        ArrayList<String> NameList = new ArrayList<>();

        int boyCount = 0,girlCount = 0;
        for (int j = 0; j < 100000; j++) {  //循环一百万次
            Collections.shuffle(boyNameList);
            Collections.shuffle(girlNameList);
            for (int i = 0; i < 7; i++) {
                NameList.add(boyNameList.get(i));
            }
            for (int i = 0; i < 3; i++) {
                NameList.add(girlNameList.get(i));
            }
            //System.out.println(NameList);
            Collections.shuffle(NameList);
            String name = NameList.get(0);
            //System.out.println(name);
            String gender = name.split("-")[1];
            if ("男".equals(gender)){
                boyCount++;
            }else {
                girlCount++;
            }
        }
        System.out.println("男："+boyCount+",女："+girlCount);

    }
}
