package file;

import java.io.File;
import java.io.IOException;

public class Demo4 {
    public static void main(String[] args) throws IOException {
        File f = new File("src\\file\\aaa","abc.txt");
        boolean b = f.createNewFile();
        if (b){
            System.out.println("创建成功");
        }else {
            System.out.println("创建失败");
        }
    }
}
