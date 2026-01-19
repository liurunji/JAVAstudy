package io.serializedStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Demo4 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\io\\serializedStream\\student1.txt"));
        //直接读取arraylist
        ArrayList<Student1> list = (ArrayList<Student1>) ois.readObject();

        for (Student1 s : list) {
            System.out.println(s);
        }
        ois.close();
    }
}
