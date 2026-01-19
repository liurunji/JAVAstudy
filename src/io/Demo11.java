package io;

import java.io.*;

public class Demo11 {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("F:\\研究生\\新建文件夹\\大作业2\\媒体素材\\非遗视频.mp4"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src\\io\\copy3.mp4"));
        int b;
        byte[] bytes = new byte[1024*1024*5];
        while ((b = bis.read(bytes))!=-1){
            bos.write(bytes,0,b);
        }
        bos.close();
        bis.close();
    }
}
