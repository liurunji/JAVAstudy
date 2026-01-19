package io.practice;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Demo4 {
    public static void main(String[] args) throws IOException {
        //1.读取数据   4-7-1-9-5-6-8-2
        FileReader fr = new FileReader("src\\io\\practice\\a.txt");
        StringBuilder sb = new StringBuilder();
        int b;
        while ((b = fr.read()) != -1) {
            sb.append((char) b);
        }

        //2.排序
        String[] str = sb.toString().split("-");
        ArrayList<Integer> list = new ArrayList<>();
        for (String s : str) {
            list.add(Integer.parseInt(s));
        }
        Collections.sort(list);

        //3.
        FileWriter fw = new FileWriter("src\\io\\practice\\a.txt");
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                fw.write(list.get(i) + "");
            } else {
                fw.write(list.get(i) + "-");
            }
        }

        fw.close();
        fr.close();
    }
}
