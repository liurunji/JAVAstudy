package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
换行和续写
 */
public class Demo2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("src\\io\\a.txt",true);
        String str1 = "aefnhwifnwQ";
        byte[] bytes1 = str1.getBytes();
        fos.write(bytes1);

        String str2 = "\r\n";
        byte[] bytes2 = str2.getBytes();
        fos.write(bytes2);

        String str3 = "666";
        byte[] bytes3 = str3.getBytes();
        fos.write(bytes3);

        fos.close();
    }
}
