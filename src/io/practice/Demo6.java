package io.practice;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Demo6 {
    public static void main(String[] args) throws IOException {
        /*
        恢复出师表的顺序，并写到新文件中
         */
        BufferedReader br = new BufferedReader(new FileReader("src\\io\\practice\\csb.txt"));
        String line;
        ArrayList<String> list = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        br.close();

        //排序，注意不能用默认方法，如果序号是两位数就会有问题了
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i1 = Integer.parseInt(o1.split("\\.")[0]);
                int i2 = Integer.parseInt(o2.split("\\.")[0]);
                return i1-i2;
            }
        });
        System.out.println(list);

        BufferedWriter bw = new BufferedWriter(new FileWriter("src\\io\\practice\\出师表.txt"));
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            bw.write(str);
            bw.newLine();
        }
        bw.close();

    }
}
