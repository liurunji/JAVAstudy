package io.zipStream;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Demo3 {
    public static void main(String[] args) throws IOException {
        //1.创建file对象表示要压缩文件夹
        File src = new File("F:\\ideaProject\\JAVAstudy\\src\\io\\zipStream\\test");
        //2.获得压缩包放置位置的父级路径
        File parentPath = new File(src.getParent());
        //3.创建file对象表示压缩包位置
        File des = new File(parentPath,src.getName()+".zip");
        //4.创建压缩流关联压缩包存放位置
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(des));
        //5.把每一个文件或文件夹放入entrySet里
        toZip(src,zos,src.getName());
        //6.关闭资源
        zos.close();

    }

    private static void toZip(File src, ZipOutputStream zos, String parent) throws IOException {
        //遍历文件夹
        File[] files = src.listFiles();
        for (File file : files) {
            if(file.isFile()){
                //是文件那就变成zipEntry对象放入压缩包中
                ZipEntry entry = new ZipEntry(parent + "\\" + file.getName());
                zos.putNextEntry(entry);
                //到这里只是把结构搭好，文件里面是空的，下面要写入数据
                FileInputStream fis = new FileInputStream(file);
                int b;
                while ((b =fis.read())!=-1){
                    zos.write(b);
                }
                fis.close();
                zos.closeEntry();
            }else {
                //是文件夹
                toZip(file,zos,parent+"\\"+file.getName());
            }
        }
    }
}
