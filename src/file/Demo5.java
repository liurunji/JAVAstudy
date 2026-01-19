package file;

import java.io.File;

public class Demo5 {
    public static void main(String[] args) {
        /*
        需求:
        定义一个方法找某一个文件夹中，是否有以avi结尾的电影(暂时不需要考虑子文件夹)
         */
        File f = new File("F:\\研究生");
        boolean b = Exist(f);
        System.out.println(b);

    }

    public static boolean Exist(File f) {
        File[] files = f.listFiles();
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".avi")) {
                return true;
            }
        }
        return false;
    }
}
