package file;

import java.io.File;

public class Demo7 {
    public static void main(String[] args) {
        //删除多级文件夹
        File f = new File("F:\\ideaProject\\JAVAstudy\\src\\file\\aaa");
        delete(f);
    }

    private static void delete(File src) {
        File[] files = src.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {//如果是文件就删除
                    file.delete();
                } else {//是文件夹就进入递归删除
                    delete(file);
                }
            }
            //删除自己
            src.delete();
        }
    }
}
