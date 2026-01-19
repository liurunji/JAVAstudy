package io.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        /*
        拷贝文件夹，考虑子文件夹
         */


        File src = new File("F:\\研究生\\组会");
        File des = new File("src\\io\\practice\\copy");

        copy(src,des);



    }

    private static void copy(File src, File des) throws IOException {
        des.mkdirs();
        byte[] bytes = new byte[1024 * 1024 * 5];
        int len;
        File[] files = src.listFiles();
        for (File file : files) {
            if (file.isFile()) {//是文件
                FileInputStream fis = new FileInputStream(file);   //字节流的参数必须是文件
                FileOutputStream fos = new FileOutputStream(new File(des,file.getName()));  //字节流的参数必须是文件
                while ((len = fis.read(bytes)) != -1) {
                    fos.write(bytes, 0, len);
                }
                //关闭流
                fos.close();
                fis.close();
            } else {
                //是文件夹
                copy(file,new File(des,file.getName()));   //这里注意第二个参数
            }
        }
    }
}
