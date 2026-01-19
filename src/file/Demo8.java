package file;

import java.io.File;

/*
统计文件夹大小
 */
public class Demo8 {
    public static void main(String[] args) {
        File f = new File("F:\\研究生\\PDR");
        long l = totalSpace(f);
        System.out.println(l / 1024 / 1024);
    }

    public static long totalSpace(File f) {
        long len = 0; //定义累加变量
        File[] files = f.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    //是文件
                    len = len + file.length();
                } else {
                    //是文件夹
                    len = len + totalSpace(file);
                }
            }
        }
        return len;
    }
}
