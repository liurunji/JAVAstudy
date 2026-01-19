package io;

import java.io.*;

/*
转换流
 */
public class Demo14 {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("src\\io\\gbkfile.txt"),"GBK");
        int b;
        while ((b = isr.read())!=-1){
            System.out.print((char) b);
        }
        isr.close();
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("src\\io\\outputFile.txt"),"GBK");
        osw.write("hahd返回弄热改回去俄日哦");
        osw.close();
    }
}
