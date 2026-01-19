package io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo7 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("src\\io\\b.txt");
        int ch;
        while ((ch = fr.read())!= -1){
            System.out.print((char) ch);
        }
        fr.close();
    }
}
