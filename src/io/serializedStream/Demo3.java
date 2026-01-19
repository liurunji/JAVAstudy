package io.serializedStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class Demo3 {
    public static void main(String[] args) throws IOException {
        /*
        将多个自定义对象序列化到文件中，但是对象的个数不确定，该如何操作呢?
         */

        Student1 s1 = new Student1("张三",23,"南京");
        Student1 s2 = new Student1("李四",24,"青岛");
        Student1 s3 = new Student1("王五",25,"北京");

        ArrayList<Student1> list = new ArrayList<>();
        Collections.addAll(list,s1,s2,s3);

        ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream("src\\io\\serializedStream\\student1.txt"));

        //直接对集合进行序列化
        oos.writeObject(list);

        oos.close();


    }
}
