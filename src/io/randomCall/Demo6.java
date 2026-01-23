package io.randomCall;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Demo6 {
    public static void main(String[] args) throws IOException {
        /*需求：
            一个文件里面存储了班级同学的姓名，每一个姓名占一行。
            要求通过程序实现随机点名器。

          运行结果要求：
            被点到的学生不会再被点到。
            但是如果班级中所有的学生都点完了， 需要重新开启第二轮点名。

          核心思想：
               点一个删一个，把删除的备份，全部点完时还原数据。

        */
        //1.定义变量表示存储所有学生信息的文件
        String src = "src/io/randomCall/names.txt";
        //2.定义备份文件的路径，文件初始为空
        String backup = "src/io/randomCall/backup.txt";
        //3.读取所有学生信息存储到集合中
        ArrayList<String> list = readFile(src);

        //如果集合中没有信息了，这说明一轮点名已经结束，就开始新一轮点名
        if (list.size() == 0){
            //把备份文件backup的信息读取然后保存到list
            list = readFile(backup);
            //把数据写入到src文件里（因为此时src文件为空被删没了）
            writeFile(src,list,false);
            //注意还要把备份文件给删掉，下面新一轮点名需要空的备份文件  （这点不容易想到）
            new File(backup).delete();
        }

        //集合中有信息，则打乱然后取第一个输出然后删除
        Collections.shuffle(list);
        String stuInfo = list.remove(0);  //方法会返回被删除的元素
        System.out.println(stuInfo);
        //删除之后，把剩余的学生信息覆盖写到原文件中（src文件）
        writeFile(src,list,false);
        //把删除的那个学生的信息追加到备份文件中
        writeFile(backup,stuInfo,true);



    }

    /*
    参数一：原文件  参数二：剩余学生信息的集合  参数三：是否追加
     */
    private static void writeFile(String src, ArrayList<String> list, boolean isAppend) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(src,isAppend));
        for (String stuInfo : list) {
            bw.write(stuInfo);
            bw.newLine();
        }
        bw.close();
    }

    //读文件数据
    private static ArrayList<String> readFile(String src) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(src));
        String line ;
        while ((line = br.readLine())!=null){
            list.add(line);
        }
        br.close();
        return list;
    }

    //写文件数据
    private static void writeFile(String backup, String stuInfo, boolean isAppend) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(backup,isAppend));
        bw.write(stuInfo);
        bw.newLine();
        bw.close();
    }
}
