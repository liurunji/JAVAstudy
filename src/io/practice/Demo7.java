package io.practice;

import java.io.*;
import java.util.TreeMap;
import java.util.function.BiConsumer;

public class Demo7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src\\io\\practice\\csb.txt"));
        String line;
        TreeMap<Integer, String> tm = new TreeMap<>();  //treemap自带排序
        while ((line = br.readLine()) != null) {
            String[] split = line.split("\\.");
            int i = Integer.parseInt(split[0]);
            tm.put(i, split[1]);
        }
        br.close();
        System.out.println(tm);
        BufferedWriter bw = new BufferedWriter(new FileWriter("src\\io\\practice\\出师表1.txt"));
        tm.forEach(new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer i, String s) {
                try {
                    bw.write(i + "." + s);
                    bw.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        bw.close();
    }
}
