package file;

import java.io.File;
import java.io.IOException;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("F:\\ideaProject\\JAVAstudy\\src\\file\\b.txt");
        boolean b = f1.createNewFile();
        System.out.println(b);
        File f2 =new File("F:\\ideaProject\\JAVAstudy\\src\\file\\aaa");
        boolean b1 = f2.mkdir();
        System.out.println(b1);
        File f3 =new File("F:\\ideaProject\\JAVAstudy\\src\\file\\aaa\\bbb\\ccc");
        boolean b2 = f3.mkdirs();
        System.out.println(b2);

        File f4 =new File("F:\\ideaProject\\JAVAstudy\\src\\file\\aaa");
        boolean b4 = f4.delete();
        System.out.println(b4);
    }
}
