package io.printStream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("src\\io\\printStream\\b.txt"));
        pw.println(97);
        pw.print(true);
        pw.println();
        pw.printf("%s额范围%d","张三",24);
        pw.close();
    }
}
