package io.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("src\\io\\practice\\ency.jpg");
        FileOutputStream fos = new FileOutputStream("src\\io\\practice\\after.jpg");

        int b;
        while ((b = fis.read()) != -1) {
            fos.write(b ^ 10);
        }

        fos.close();
        fis.close();
    }
}
