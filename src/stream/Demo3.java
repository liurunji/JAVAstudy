package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.IntFunction;

public class Demo3 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张三", "陆临川", "沈知意", "江晚", "周默然", "张三", "江晚", "江晚", "张三", "张三", "叶蓁蓁", "张三丰");

        /*
        String[] arr = list.stream().toArray(new IntFunction<String[]>() {
            @Override
            public String[] apply(int value) {
                return new String[value];
            }
        });
         */

        String[] arr = list.stream().toArray(value -> new String[value]);

        System.out.println(Arrays.toString(arr));
    }
}
