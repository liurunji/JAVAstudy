package io.practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Demo5 {
    public static void main(String[] args) throws IOException {
        //1.读取数据   4-7-1-9-5-6-8-2
        FileReader fr = new FileReader("src\\io\\practice\\a.txt");
        StringBuilder sb = new StringBuilder();
        int b;
        while ((b = fr.read()) != -1) {
            sb.append((char) b);
        }
        fr.close();

        //2.排序
        Integer[] arr = Arrays.stream(sb.toString().split("-"))
                .map(Integer::parseInt)
                .sorted()
                .toArray(Integer[]::new);
        System.out.println(Arrays.toString(arr));

        //3.写出
        FileWriter fw= new FileWriter("src\\io\\practice\\a.txt");
        String str = Arrays.toString(arr).replace(", ", "-");

        System.out.println(str);
        String result = str.substring(1, str.length() - 1);
        fw.write(result);
        fw.close();


    }
}
