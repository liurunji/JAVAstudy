package io.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("src\\io\\practice\\tupian.jpg");
        FileOutputStream fos = new FileOutputStream("src\\io\\practice\\ency.jpg");

        int b;
        while ((b = fis.read()) != -1) {
            fos.write(b ^ 10);
        }

        fos.close();
        fis.close();
    }
}
