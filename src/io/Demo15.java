package io;

import java.io.*;

public class Demo15 {
    public static void main(String[] args) throws IOException {
        /*
        将本地文件中的GBK文件，转成UTF-8
         */
        InputStreamReader isr = new InputStreamReader(new FileInputStream("src\\io\\gbkfile.txt"),"GBK");
        OutputStreamWriter isw = new OutputStreamWriter(new FileOutputStream("src\\io\\utf-8file.txt"),"UTF-8");
        int b;
        while ((b = isr.read())!=-1){
            isw.write(b);
        }
        isw.close();
        isr.close();
    }
}
