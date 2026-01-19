package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Demo3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("src\\io\\a.txt");
        int p;
        while ((p = fis.read()) != -1) {
            System.out.print((char) p);
        }
        fis.close();
    }
}
