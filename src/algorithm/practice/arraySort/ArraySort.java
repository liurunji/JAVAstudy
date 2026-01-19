package algorithm.practice.arraySort;

import java.util.Arrays;
import java.util.Comparator;

public class ArraySort {
    public static void main(String[] args) {
        //定义数组并存储一些女朋友对象，利用Arrays中的sort方法进行排序
        // 要求1:属性有姓名、年龄、身高。
        // 要求2:按照年龄的大小进行排序，年龄一样，按照身高排序，身高一样按照姓名的字母进行排序
        // (姓名中不要有中文或特殊字符，会涉及到后面的知识)
        GirlFriend gf1 = new GirlFriend("zhansgan", 20, 1.78);
        GirlFriend gf2 = new GirlFriend("lisi", 21, 1.75);
        GirlFriend gf3 = new GirlFriend("wangwu", 21, 1.77);
        GirlFriend gf4 = new GirlFriend("awei", 21, 1.77);
        GirlFriend gf5 = new GirlFriend("wangwu", 21, 1.77);
        GirlFriend[] arr = {gf1, gf2, gf3, gf4};

        /*
        //匿名内部类形式
        Arrays.sort(arr, new Comparator<GirlFriend>() {
            @Override
            public int compare(GirlFriend o1, GirlFriend o2) {
                if (o1.getAge() != o2.getAge())
                    return o1.getAge() - o2.getAge();
                if (o1.getHeight() < o2.getHeight()) {
                    return -1;
                } else if (o1.getHeight() > o2.getHeight()) {
                    return 1;
                }
                return o1.getName().compareTo(o2.getName());
            }
        });
        */

        //lambda表达式
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.getAge() != o2.getAge())
                return o1.getAge() - o2.getAge();
            if (o1.getHeight() < o2.getHeight()) {
                return -1;
            } else if (o1.getHeight() > o2.getHeight()) {
                return 1;
            }
            return o1.getName().compareTo(o2.getName());
        });

        System.out.println(Arrays.toString(arr));

    }
}
