package collection.set.treeSet;

import java.util.Comparator;
import java.util.TreeSet;

public class Test1 {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>((String o1, String o2)-> {
                int i = o1.length() - o2.length();
                i = i == 0?o1.compareTo(o2):i;
                return i;
        });


        ts.add("c");
        ts.add("ab");
        ts.add("ds");
        ts.add("abcde");
        ts.add("qwer");

        for (String t : ts) {
            System.out.println(t);
        }


    }
}
