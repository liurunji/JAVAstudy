package io.printStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class Demo1 {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        PrintStream ps = new PrintStream(new FileOutputStream("src\\io\\printStream\\a.txt"),true,"UTF-8");
        ps.println(97);
        ps.print(true);
        ps.println();
        ps.printf("%s打了%d次车","张三",24);
        ps.close();
    }
}
