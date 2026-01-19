package io;

import java.io.FileWriter;
import java.io.IOException;

public class Demo9 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("src\\io\\c.txt",true);
        //fw.write(34201);
        //fw.write("我是你爹123");
        //fw.write("张三李四王五",2,3);
        char[] chars = {'a','c','物','b','是','的'};
        fw.write(chars);
        fw.write(chars,1,3);
        fw.close();
    }
}
