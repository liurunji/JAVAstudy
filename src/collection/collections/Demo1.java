package collection.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Demo1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"aaa","123","zhansgan","类似","zzz","scvfa");
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);

    }
}
