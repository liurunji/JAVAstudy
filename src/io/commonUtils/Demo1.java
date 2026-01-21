package io.commonUtils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        //IOUtils.copy(new FileInputStream("D:\\Microsoft Edge Download\\gbkfile.txt"), new FileOutputStream("src\\io\\commonUtils\\csb.txt"));
        //FileUtils.copyDirectory(new File("D:\\Microsoft Edge Download\\windsurf-win"), new File("src\\io\\commonUtils\\"));
        FileUtils.copyDirectoryToDirectory(new File("D:\\Microsoft Edge Download\\windsurf-win"), new File("src\\io\\commonUtils\\"));
    }
}
