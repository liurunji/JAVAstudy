package io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Demo13 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("src\\io\\d.txt",true));
        bw.write("zhangsan");
        bw.newLine();
        bw.write("打飞我副科老年服务可怜人够吗你啦污染");
        bw.newLine();

        bw.close();
    }
}
