package io;

import java.io.*;

public class Demo10 {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("F:\\研究生\\新建文件夹\\大作业2\\媒体素材\\非遗视频.mp4"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src\\io\\practice\\copy.mp4"));
        int b;
        while ((b = bis.read())!=-1){
            bos.write(b);
        }
        bos.close();
        bis.close();
    }
}
