package collection.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Demo2 {
    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<>();
        Collections.addAll(l1, 1, 18, 42, 41, 6320, 12, 5);
        System.out.println(l1);
        Collections.sort(l1);
        System.out.println(l1);
        Collections.sort(l1, (o1, o2) -> o2 - o1);
        System.out.println(l1);

        Collections.sort(l1);


        int i = Collections.binarySearch(l1, 40);
        System.out.println(i);

        Collections.fill(l1,100);
        System.out.println(l1);   //指定元素填充（全覆盖）集合

        ArrayList<Integer> l2 = new ArrayList<>();
        Collections.addAll(l2, 1, 18, 42, 41, 6320, 12, 5);
        ArrayList<Integer> l3 = new ArrayList<>();
        Collections.addAll(l3, 1000, 2000, 3000, 4000);
        Collections.copy(l2,l3);
        System.out.println(l2);  //[1000, 2000, 3000, 4000, 6320, 12, 5]覆盖

        Integer min = Collections.min(l3);
        System.out.println(min);
        Integer max = Collections.max(l3);
        System.out.println(max);

        Collections.swap(l3,0,3);
        System.out.println(l3);
    }
}
