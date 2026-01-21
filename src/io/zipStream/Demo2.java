package io.zipStream;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        File src = new File("F:\\研究生\\新建文件夹\\test\\a.txt");
        File des = new File("F:\\研究生\\新建文件夹\\test\\");
        zip(src, des);
    }

    private static void zip(File src, File des) throws IOException {
        //创建压缩流关联压缩包
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(new File(des, "a.zip")));
        //创建zipEntry对象，表示压缩包里的每一个文件和文件夹
        ZipEntry entry = new ZipEntry("a.txt");
        //把zipEntry对象放入到压缩包里
        zos.putNextEntry(entry);

        //把src文件中的a.txt写入压缩包中
        FileInputStream fis = new FileInputStream(src);
        int b;
        while ((b = fis.read()) != -1) {
            zos.write(b);
        }

        fis.close();
        zos.close();

    }
}
