package io.zipStream;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        File src = new File("F:\\研究生\\新建文件夹\\test.zip");
        File des = new File("F:\\ideaProject\\JAVAstudy\\src\\io\\zipStream\\");
        unzip(src,des);
    }

    public static void unzip(File src, File des) throws IOException {
        ZipInputStream zis = new ZipInputStream(new FileInputStream(src));
        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            System.out.println(entry);
            if (entry.isDirectory()){
                //是文件夹，那就创建对应文件夹到目的地
                File f = new File(des,entry.toString());
                f.mkdirs();
            }else {
                //是文件则读取文件并保存到对应结构目录下
                FileOutputStream fos = new FileOutputStream(new File(des,entry.toString()));
                int b;
                while ((b= zis.read())!=-1){
                    fos.write(b);
                }
                fos.close();
                //表示压缩包中的一个文件处理完了
                zis.closeEntry();
            }
        }
        zis.close();

    }
}
