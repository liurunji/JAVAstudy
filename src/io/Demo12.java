package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Demo12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src\\io\\b.txt"));
        String s ;
        while ((s = br.readLine())!=null){
            System.out.println(s);
        }
        br.close();
    }
}
