package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo6 {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        FileInputStream fis = new FileInputStream("F:\\研究生\\导出\\DJI_0550.mp4");
        FileOutputStream fos = new FileOutputStream("src\\io\\copy2.mp4");

        int len;
        byte[] bytes = new byte[1024 * 1024 * 5];  //5M的数组
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes,0,len);
        }
        fos.close();
        fis.close();

        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }


}
