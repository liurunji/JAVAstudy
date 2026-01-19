package io.serializedStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Demo2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*
        反序列化流
         */
        //1.创建反序列化对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\io\\serializedStream\\student.txt"));
        //2.读取数据
        //Object o = ois.readObject();
        Student s = (Student) ois.readObject();

        //3.打印对象
        //System.out.println(o);
        System.out.println(s);
        //关闭资源
        ois.close();

    }
}
