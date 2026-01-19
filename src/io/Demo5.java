package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Demo5 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("src\\io\\a.txt");
        byte[] bytes = new byte[20];
        int len1 = fis.read(bytes);
        System.out.println(len1);
        System.out.println(new String(bytes,0,len1));

        int len2 = fis.read(bytes);
        System.out.println(len2);
        System.out.println(new String(bytes,0,len2));
    }
}
