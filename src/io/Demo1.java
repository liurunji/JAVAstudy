package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("src/io/a.txt");
        //fos.write(98);

        byte[] b = {97,98,99,100,101,102};
        //fos.write(b);

        fos.write(b,1,3);

        fos.close();
    }
}
