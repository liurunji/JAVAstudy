package io.serializedStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        //1.创建对象
        Student stu = new Student("zhangsan",23);
        //2.创建序列化流的对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\io\\serializedStream\\student.txt"));
        //3.写入数据
        oos.writeObject(stu);
        //4.关闭流
        oos.close();

    }
}
