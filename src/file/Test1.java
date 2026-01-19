package file;

import java.io.File;

public class Test1 {
    public static void main(String[] args) {
        File f = new File("F:\\研究生\\算法分析\\期末\\人工智能\\人工智能往年期末资料");
        File[] files = f.listFiles();
        for (File file : files) {
            String name = file.getName();
            int i = name.lastIndexOf(".");
            System.out.println(i);
            System.out.println(name);
            String fileName = file.getName();
            int index = fileName.lastIndexOf(".");
            String suffix = fileName.substring(index);
            System.out.println(suffix);
        }
    }
}
