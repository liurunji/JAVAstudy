package file;

import java.io.File;

public class Demo3 {
    public static void main(String[] args) {
        File f1  = new File("F:\\ideaProject\\JAVAstudy\\src\\file");
        File[] files = f1.listFiles();
        for (File file : files) {
            System.out.println(file);
        }

        System.out.println("-------------------------");
        File f2  = new File("F:\\ideaProject\\JAVAstudy\\src\\file");
        File[] files1 = f2.listFiles();
        for (File file : files1) {
            if (file.isFile()&&file.getName().endsWith(".txt")) {
                System.out.println(file);
            }
        }
    }
}
